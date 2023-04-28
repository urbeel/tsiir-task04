package by.urbel.task04.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "cart_items")
public class CartItem {
    @EmbeddedId
    private CartItemId itemId = new CartItemId();
    @Column(nullable = false)
    private int quantity;
}
