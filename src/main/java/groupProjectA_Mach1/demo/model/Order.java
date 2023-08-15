package groupProjectA_Mach1.demo.model;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "orderEntity")
public class Order {

    @Id
    @GeneratedValue
    private long id;
    private String supplier;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn (name = "order_id")
    private Set<Product> product;
    private int quantity;

    public Order() { }

    public Order(String supplier,
                 Set<Product> product,
                 int quantity) {
        this.supplier = supplier;
        this.product = product;
        this.quantity = quantity;
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

    public Set<Product> getProduct() { return product; }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setProduct(Set<Product> product) { this.product = product; }

    @Override
    public String toString() {
        return "Order{" +
                "supplier='" + supplier + '\'' +
               ", product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}
