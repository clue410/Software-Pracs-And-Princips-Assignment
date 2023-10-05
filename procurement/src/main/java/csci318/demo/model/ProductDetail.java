package csci318.demo.model;

import javax.persistence.*;

@Embeddable
public class ProductDetail extends org.springframework.data.domain.AbstractAggregateRoot<Product> {

    private ProductDetailID productDetailID; // Aggregate Identifier

    @Embedded
    private ProductDetailValueObject productDetailValueObject;
    public ProductDetail() {

    }

    public ProductDetail(long id, String comment, String description) {
        this.productDetailID = new ProductDetailID(id);
        this.productDetailValueObject = new ProductDetailValueObject(comment, description);
    }

    public ProductDetailID getProductDetailID() {
        return productDetailID;
    }

    public void setProductDetailID(ProductDetailID productDetailID) {
        this.productDetailID = productDetailID;
    }

    public ProductDetailValueObject getProductDetailValueObject() {
        return productDetailValueObject;
    }

    public void setProductDetailValueObject(ProductDetailValueObject productDetailValueObject) {
        this.productDetailValueObject = productDetailValueObject;
    }
}

