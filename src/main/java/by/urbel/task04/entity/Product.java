package by.urbel.task04.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Data
@Entity
@Table(name = "products")
public class Product implements Comparable<Product> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 50)
    private String name;
    @ManyToOne(optional = false)
    private ProductCategory category;
    @Column(length = 500)
    private String description;
    @Column(nullable = false)
    private long price;
    @Column(nullable = false)
    private int quantity;
    @Column(nullable = false)
    private String photoUrl;

    @Override
    public int compareTo(Product product) {
        return id.compareTo(product.getId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
