package by.urbel.task04.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@Embeddable
public class CartItemId implements Serializable {
    @Serial
    private static final long serialVersionUID = -7033448237144136986L;

    @ManyToOne
    private Product product;
    @ManyToOne
    private Cart cart;
}
