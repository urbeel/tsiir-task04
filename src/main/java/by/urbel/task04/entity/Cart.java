package by.urbel.task04.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "carts")
public class Cart {
    @Id
    @Column(name = "user_id")
    private Long id;
    @OneToOne(optional = false, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    @MapsId
    private User user;
    @OneToMany(mappedBy = "itemId.cart", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<CartItem> items;
    @Column(nullable = false)
    private long totalPrice;
}
