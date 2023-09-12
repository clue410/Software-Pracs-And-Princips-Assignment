
package groupProjectA_Mach1.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "orderEntity")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    public String supplier;

    public long productId;
    public int quantity;

    public Order(String supplier) {
        this.supplier = supplier;
    }

    public Order(String supplier, long productId, int quantity) {
        this.supplier = supplier;
        this.productId = productId;
        this.quantity = quantity;
    }

    public Order() {

    }

    public long getId() {
        return id;
    }

    public String getSupplier() {
        return supplier;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Order{" +
                "supplier='" + supplier + '\'' +
                ", product id=" + productId +
                ", quantity=" + quantity +
                '}';
    }
}
