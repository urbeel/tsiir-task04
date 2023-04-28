package by.urbel.task04.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class OrderItemId implements Serializable {
    @Serial
    private static final long serialVersionUID = -27387038815118817L;

    @ManyToOne
    private Product product;
    @ManyToOne
    private Order order;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderItemId that = (OrderItemId) o;

        if (!Objects.equals(product, that.product)) return false;
        return Objects.equals(order, that.order);
    }

    @Override
    public int hashCode() {
        int result = product != null ? product.hashCode() : 0;
        result = 31 * result + (order != null ? order.hashCode() : 0);
        return result;
    }
}
