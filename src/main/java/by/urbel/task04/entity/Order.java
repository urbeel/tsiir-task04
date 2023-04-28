package by.urbel.task04.entity;

import by.urbel.task04.entity.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@Table(name = "orders")
public class Order implements Comparable<Order> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(optional = false)
    private User user;
    @Column(nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    @OneToMany(mappedBy = "itemId.order", cascade = CascadeType.ALL)
    private Set<OrderItem> items;
    @Column(nullable = false)
    private Timestamp orderTime;
    @Column(nullable = false)
    private long totalPrice;

    @Override
    public int compareTo(Order order) {
        return id.compareTo(order.getId());
    }

    @PrePersist
    private void setOrderDate() {
        this.orderTime = Timestamp.from(Instant.now());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
