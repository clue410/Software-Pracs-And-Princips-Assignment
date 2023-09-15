
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
    private long productId;
    private int quantity;
    private String status;
    private long customerId;

    public Order() {    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "status='" + status + '\'' +
                ", customer id=" + customerId + '\'' +
                ", supplier='" + supplier + '\'' +
                ", product id=" + productId + '\'' +
                ", quantity=" + quantity +
                '}';
    }

    public void buy(long orderId) {
        this.setStatus("paid");

        OrderEvent orderEvent = new OrderEvent();
        orderEvent.setEventName("buy");
        orderEvent.setQuantity(this.getQuantity());
        orderEvent.setSupplier(this.getSupplier());
        orderEvent.setProductId(this.getProductId());
        orderEvent.setOrderId(orderId);
        orderEvent.setStatus(this.getStatus());
        orderEvent.setCustomerId(this.getCustomerId());

        registerEvent(orderEvent);
    }
}