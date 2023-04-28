package by.urbel.task04.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Messages {
    public static final String USER_ID_NOT_NULL = "User id cannot be null";
    public static final String USER_NOT_NULL = "User cannot be null";
    public static final String PASSWORD_NOT_EMPTY = "Password cannot be empty";
    public static final String PASSWORD_SIZE = "Password must be between 6 and 16 characters long";
    public static final String ORDER_ITEMS_NOT_EMPTY = "Order items cannot be empty";
    public static final String CATEGORY_NOT_NULL = "Category cannot be null";
    public static final String CATEGORY_ID_NOT_NULL = "Category id cannot be null";
    public static final String CATEGORY_NAME_NOT_EMPTY = "Category name cannot be empty";
    public static final String CATEGORY_NAME_SIZE = "Max length of category name is 20 characters";
    public static final String EMAIL_NOT_EMPTY = "Email cannot be empty";
    public static final String INVALID_EMAIL = "Invalid email";
    public static final String EMAIL_SIZE = "Max length of email is 60 characters";
    public static final String FIRSTNAME_SIZE = "Max length of firstname is 45 characters";
    public static final String FIRSTNAME_NOT_EMPTY = "Firstname cannot be empty";
    public static final String LASTNAME_SIZE = "Max length of lastname is 45 characters";
    public static final String LASTNAME_NOT_EMPTY = "Lastname cannot be empty";
    public static final String PHONE_SIZE = "Max length of phone number is 20 characters";
    public static final String PHONE_NOT_EMPTY = "Phone number cannot be empty";
    public static final String ADDRESS_SIZE = "Max length of address is 255 characters";
    public static final String ADDRESS_NOT_EMPTY = "Phone number cannot be empty";
    public static final String INCORRECT_EMAIL_PASSWORD = "Incorrect email or password";
    public static final String PRODUCT_NOT_NULL = "Product cannot be null";
    public static final String PRODUCT_ID_NOT_NULL = "Product id cannot be null";
    public static final String ID_NOT_NULL = "Id cannot be null";
    public static final String PRODUCT_NAME_NOT_EMPTY = "Product name cannot be empty";
    public static final String PRODUCT_NAME_SIZE = "Max length of product name is 50 characters";
    public static final String PRODUCT_DESCRIPTION_SIZE = "Max length of product description is 500 characters";
    public static final String PRODUCT_PRICE_POSITIVE = "Product price must be positive";
    public static final String PRODUCT_QUANTITY_NOT_NEGATIVE = "Product quantity cannot be negative";
    public static final String ITEM_POSITIVE_QUANTITY = "Product quantity must be positive";
    public static final String MUST_BE_ENUM = "Must be any of enum {enumClass}";
    public static final String PRODUCT_NOT_FOUND = "Product with id %d not found";
    public static final String CART_NOT_FOUND = "Cart with id %d not found";
    public static final String CATEGORY_NOT_FOUND = "Category with id %d not found";
    public static final String CATEGORY_EXISTS = "Category %s already exists";
    public static final String USER_NOT_FOUND = "User %s not found";
    public static final String ORDER_NOT_FOUND = "Order with id %d not found";
    public static final String INVALID_PHOTO_URL = "Invalid photo url. Photo not deleted";
    public static final String UPDATE_CART = "Order rejected. " +
            "The quantity of products in the cart has been changed based on stock. Check your cart and try again.";
}
