package groupProjectA_Mach1.demo.model;

import javax.persistence.*;
import java.io.Serializable;
@Embeddable
public class ProductDetailID implements Serializable{
    //    @Id
    @Column(name="productDetailId")
//    @GeneratedValue
    private long productDetailId;

    public ProductDetailID(){};
    public ProductDetailID(long productDetailId){
        this.productDetailId = productDetailId;
    }

    public long getProductDetailId() {
        return productDetailId;
    }

    public void setProductDetailId(long productDetailId) {
        this.productDetailId = productDetailId;
    }
}