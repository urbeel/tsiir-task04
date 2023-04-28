package by.urbel.task04.repository;

import by.urbel.task04.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByQuantityIsGreaterThan(int value);
}
