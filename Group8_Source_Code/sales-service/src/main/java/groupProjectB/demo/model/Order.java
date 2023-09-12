
package groupProjectB.demo.model;

import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "orderEntity")
public class Order extends AbstractAggregateRoot<Order> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String supplier;
    private Long productId;
    private int quantity;
    public Order(String supplier, Long productId) {
        this.supplier = supplier;
        this.productId = productId;
    }

    public Order() {    }

    public Long getId() {
        return id;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "Order{" +
                ", supplier='" + supplier + '\'' +
                ", product id=" + productId +
                ", quantity=" + quantity +
                '}';
    }
}
