package by.urbel.task04.controller;

import by.urbel.task04.controller.constants.Routes;
import by.urbel.task04.customvalidation.ValueOfEnum;
import by.urbel.task04.dto.OrderDto;
import by.urbel.task04.entity.enums.OrderStatus;
import by.urbel.task04.entity.enums.Role;
import by.urbel.task04.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Routes.ORDERS)
@RequiredArgsConstructor
@Validated
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    @PreAuthorize("hasRole('CUSTOMER') and #orderDto.user.id==principal.id")
    public void create(@RequestBody @Valid OrderDto orderDto) {
        orderService.create(orderDto);
    }

    @GetMapping(Routes.ORDER_STATUS)
    @Secured(Role.Constants.ADMIN_ROLE)
    public List<OrderDto> readAllByStatus(
            @ValueOfEnum(enumClass = OrderStatus.class)
            @PathVariable String status) {
        return orderService.readAllByStatus(OrderStatus.valueOf(status.toUpperCase()));
    }

    @PatchMapping(Routes.CHANGE_ORDER_STATUS)
    @Secured(Role.Constants.ADMIN_ROLE)
    public void changeOrderStatus(@PathVariable long id,
                                  @RequestParam @ValueOfEnum(enumClass = OrderStatus.class) String newStatus) {
        orderService.changeOrderStatus(id, OrderStatus.valueOf(newStatus.toUpperCase()));
    }
}
