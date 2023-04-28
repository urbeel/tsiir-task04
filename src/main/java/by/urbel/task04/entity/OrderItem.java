package by.urbel.task04.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "order_items")
public class OrderItem {
    @EmbeddedId
    private OrderItemId itemId = new OrderItemId();
    @Column(nullable = false)
    private int quantity;
}
