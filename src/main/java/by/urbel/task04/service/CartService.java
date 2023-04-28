package by.urbel.task04.service;

import by.urbel.task04.constants.Messages;
import by.urbel.task04.dto.CartDto;
import by.urbel.task04.dto.ItemDto;
import by.urbel.task04.entity.Cart;
import by.urbel.task04.entity.CartItem;
import by.urbel.task04.entity.CartItemId;
import by.urbel.task04.entity.Product;
import by.urbel.task04.mapper.CartItemMapper;
import by.urbel.task04.mapper.CartMapper;
import by.urbel.task04.repository.CartItemRepository;
import by.urbel.task04.repository.CartRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;
    private final CartMapper cartMapper;
    private final CartItemRepository cartItemRepository;
    private final CartItemMapper cartItemMapper;

    public CartDto readById(long id) {
        Cart cart = cartRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(String.format(Messages.CART_NOT_FOUND, id)));
        return cartMapper.convert(cart);
    }

    public void addProduct(long cartId, ItemDto dto) {
        CartItem cartItem = cartItemMapper.convert(dto);
        Cart cart = new Cart();
        cart.setId(cartId);
        cartItem.getItemId().setCart(cart);
        cartItemRepository.save(cartItem);
    }

    public void deleteProduct(long cartId, long productId) {
        Cart cart = new Cart();
        cart.setId(cartId);
        Product product = new Product();
        product.setId(productId);
        CartItemId id = new CartItemId();
        id.setCart(cart);
        id.setProduct(product);
        cartItemRepository.deleteById(id);
    }
}
