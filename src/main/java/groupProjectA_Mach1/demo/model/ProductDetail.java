package groupProjectA_Mach1.demo.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEvent;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.QAbstractAuditable;


import javax.persistence.*;
import java.io.Serializable;
import java.time.Clock;

//@Entity
@Embeddable
//@NamedQueries({
//        @NamedQuery(name = "Cargo.findAll",
//                query = "Select c from Cargo c"),
//        @NamedQuery(name = "Cargo.findByBookingId",
//                query = "Select c from Cargo c where c.bookingId = ?1"),
//        @NamedQuery(name = "Cargo.findAllBookingIds",
//                query = "Select c.bookingId from Cargo c")})
public class ProductDetail extends org.springframework.data.domain.AbstractAggregateRoot<groupProjectA_Mach1.demo.model.Product> {
    //    @Id
//    @Embedded
//    @EmbeddedId
    private ProductDetailID productDetailID; // Aggregate Identifier

    @Embedded
    private ProductDetailValueObject productDetailValueObject;
//    @Embedded
//    private String description;
//    @Embedded
//    private String comment;

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

    //    public void setId(long id) {
//        this.id = id;
//    }
//
//    public void setComment(String comment) {
//        this.comment = comment;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
}


