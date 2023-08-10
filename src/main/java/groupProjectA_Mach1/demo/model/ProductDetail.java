package groupProjectA_Mach1.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProductDetail {
    @Id
//    @Column(name = "product id")
    private long id;
    private String description;
    private String comment;

    public ProductDetail() {
    }

    public ProductDetail(long id, String description, String comment) {
        this.id = id;
        this.description = description;
        this.comment = comment;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
