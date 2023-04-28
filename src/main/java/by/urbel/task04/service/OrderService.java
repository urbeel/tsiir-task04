package by.urbel.task04.service;

import by.urbel.task04.constants.Messages;
import by.urbel.task04.dto.ItemDto;
import by.urbel.task04.dto.OrderDto;
import by.urbel.task04.dto.ProductDto;
import by.urbel.task04.entity.Order;
import by.urbel.task04.entity.User;
import by.urbel.task04.entity.enums.OrderStatus;
import by.urbel.task04.mapper.OrderMapper;
import by.urbel.task04.repository.OrderRepository;
import by.urbel.task04.repository.ProductRepository;
import by.urbel.task04.service.exception.CartNeedUpdateException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final ProductService productService;
    private final OrderMapper orderMapper;
    private final CartService cartService;

    @Transactional
    public void create(OrderDto orderDto) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        boolean isItemsUpdated = false;
        for (ItemDto item : orderDto.getItems()) {
            long productId = item.getProduct().getId();
            ProductDto product = productService.readById(productId);
            if (item.getQuantity() > product.getQuantity()) {
                cartService.deleteProduct(user.getId(), productId);
                item.setQuantity(product.getQuantity());
                cartService.addProduct(user.getId(), item);
                isItemsUpdated = true;
                break;
            } else {
                orderDto.setTotalPrice(orderDto.getTotalPrice() + product.getPrice() * item.getQuantity());
                product.setQuantity(product.getQuantity() - item.getQuantity());
                item.setProduct(product);
            }
        }
        if (!isItemsUpdated) {
            Order order = orderMapper.convert(orderDto);
            orderDto.getItems().forEach(item ->
                    productService.update(item.getProduct().getId(), item.getProduct()));
            order.getItems().forEach(orderItem ->
                    orderItem.getItemId().setOrder(order));
            order.setUser(user);
            order.setStatus(OrderStatus.NEW);
            orderRepository.save(order);
        } else {
            throw new CartNeedUpdateException(Messages.UPDATE_CART);
        }
    }

    public List<OrderDto> readAllByStatus(OrderStatus status) {
        return orderMapper.convert(orderRepository.findAllByStatus(status));
    }

    public void changeOrderStatus(long orderId, OrderStatus status) {
        Order order = orderRepository.findById(orderId).orElseThrow(() ->
                new EntityNotFoundException(String.format(Messages.ORDER_NOT_FOUND, orderId)));
        order.setStatus(status);
        orderRepository.save(order);
        if (status.equals(OrderStatus.CANCELED)) {
            order.getItems().forEach(orderItem -> {
                long productId = orderItem.getItemId().getProduct().getId();
                productRepository.findById(productId).ifPresent(
                        productFromDb -> {
                            productFromDb.setQuantity(productFromDb.getQuantity() + orderItem.getQuantity());
                            productRepository.save(productFromDb);
                        }
                );
            });
        }
    }
}
