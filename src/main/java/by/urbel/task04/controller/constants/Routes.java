package by.urbel.task04.controller.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Routes {
    public static final String API_PREFIX = "/api";
    public static final String AUTH = API_PREFIX + "/auth";
    public static final String LOGIN = "/login";
    public static final String REGISTRATION = "/registration";
    public static final String USERS = API_PREFIX + "/users";
    public static final String CATEGORIES = API_PREFIX + "/categories";
    public static final String ID = "/{id}";
    public static final String PRODUCTS = API_PREFIX + "/products";
    public static final String IN_STOCK = "/in-stock";
    public static final String CARTS = API_PREFIX + "/carts";
    public static final String ADD_CART_ITEM = "/{cartId}/add-product";
    public static final String DELETE_CART_ITEM = "/{cartId}/delete-product";
    public static final String ORDERS = API_PREFIX + "/orders";
    public static final String CHANGE_ORDER_STATUS = ID + "/change-status";
    public static final String ORDER_STATUS = "/{status}";
    public static final String CREATE_ADMIN = "/create-admin";

}
