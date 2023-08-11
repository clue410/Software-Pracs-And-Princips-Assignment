package groupProjectA_Mach1.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;

public class Order {
    @Id
    @GeneratedValue
    public long id;
    public String supplier;
    @ManyToMany(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "product_id")
    @JsonIgnore
    public Product product;
    public int quantity;

    public Order(){ }

    public Order(long id,
                 String supplier,
                 Product product,
                 int quantity) {
        this.id = id;
        this.supplier = supplier;
        this.product = product;
        this.quantity = quantity;
    }

    public Order(String supplier,
                 Product product,
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

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Order{" +
                "supplier='" + supplier + '\'' +
                ", product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}
