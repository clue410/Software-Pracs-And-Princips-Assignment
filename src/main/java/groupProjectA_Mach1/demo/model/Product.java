package groupProjectA_Mach1.demo.model;

import javax.persistence.*;

@Entity(name = "productEntity")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "prodID")
    private long id;
    private String productCategory;
    private String name;
    private double price;

//    @ManyToMany(mappedBy = "product")
//    public Set<Order> order;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private ProductDetail productDetails;

    public Product() {
    }

    public Product(String productCategory, String name, double price) {
        this.productCategory = productCategory;
        this.name = name;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public ProductDetail getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(ProductDetail productDetails) {
        this.productDetails = productDetails;
    }
}
