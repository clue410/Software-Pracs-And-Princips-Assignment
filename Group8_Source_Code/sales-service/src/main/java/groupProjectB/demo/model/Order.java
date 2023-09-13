
package groupProjectB.demo.model;

import groupProjectB.demo.model.event.OrderEvent;
import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.*;

@Entity(name = "orderEntity")
public class Order extends AbstractAggregateRoot<Order> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String supplier;
    private Long productId;
    private int quantity;
    private String status;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "status='" + status + '\'' +
                ", supplier='" + supplier + '\'' +
                ", product id=" + productId + '\'' +
                ", quantity=" + quantity +
                '}';
    }

    public void buy(long orderId) {
        this.setStatus("paid");

        OrderEvent orderEvent = new OrderEvent();
        orderEvent.setEventName("borrow");
        orderEvent.setQuantity(this.getQuantity());
        orderEvent.setSupplier(this.getSupplier());
        orderEvent.setProductId(this.getProductId());
        orderEvent.setOrderId(orderId);
        orderEvent.setStatus(this.getStatus());

        registerEvent(orderEvent);
    }
}
