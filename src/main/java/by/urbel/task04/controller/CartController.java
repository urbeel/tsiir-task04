package by.urbel.task04.controller;

import by.urbel.task04.controller.constants.Routes;
import by.urbel.task04.dto.CartDto;
import by.urbel.task04.dto.ItemDto;
import by.urbel.task04.service.CartService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Routes.CARTS)
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @PostMapping(Routes.ADD_CART_ITEM)
    @PreAuthorize("hasRole('CUSTOMER') and #cartId==principal.id")
    public void addProductToCart(@PathVariable long cartId, @RequestBody @Valid ItemDto itemDto) {
        cartService.addProduct(cartId, itemDto);
    }

    @GetMapping(Routes.ID)
    @PreAuthorize("hasRole('CUSTOMER') and #id==principal.id")
    public CartDto readById(@PathVariable long id) {
        return cartService.readById(id);
    }

    @DeleteMapping(Routes.DELETE_CART_ITEM)
    @PreAuthorize("hasRole('CUSTOMER') and #cartId==principal.id")
    public void deleteProductFromCart(@PathVariable long cartId, @RequestParam long productId) {
        cartService.deleteProduct(cartId, productId);
    }
}
