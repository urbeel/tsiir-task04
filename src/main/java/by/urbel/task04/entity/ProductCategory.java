package by.urbel.task04.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "product_categories")
public class ProductCategory implements Comparable<ProductCategory> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true, length = 20)
    private String name;

    @Override
    public int compareTo(ProductCategory category) {
        return id.compareTo(category.getId());
    }
}
