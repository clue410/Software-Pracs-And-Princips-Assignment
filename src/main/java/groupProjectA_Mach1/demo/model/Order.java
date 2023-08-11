
package groupProjectA_Mach1.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "orderEntity")
public class Order {

    @Id
    @GeneratedValue
    public long id;
    public String supplier;

    public int product;
    public int quantity;

    public Order(String supplier, long product, int quantity) {
    }

    public Order(String supplier,
//                 String product,
                 int quantity) {
        this.supplier = supplier;
//        this.product = product;
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
//                ", product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}
