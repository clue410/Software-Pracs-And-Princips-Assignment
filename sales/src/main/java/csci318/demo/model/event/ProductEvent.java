package csci318.demo.model.event;

import csci318.demo.model.ProductDetail;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class ProductEvent {
    @Id
    @GeneratedValue
    private long id;
    private String eventName;
    private long productId;
    private String productCategory;
    private String name;
    private double price;
    private int stock;
    @PrimaryKeyJoinColumn
    private ProductDetail productDetails;

    public ProductEvent() {
    }

    public long getId() {
        return id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {return stock;}

    public void setStock(int stock) {this.stock = stock;}

    public ProductDetail getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(ProductDetail productDetails) {
        this.productDetails = productDetails;
    }
}
