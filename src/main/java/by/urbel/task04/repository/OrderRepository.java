package by.urbel.task04.repository;

import by.urbel.task04.entity.Order;
import by.urbel.task04.entity.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByStatus(OrderStatus status);
}
