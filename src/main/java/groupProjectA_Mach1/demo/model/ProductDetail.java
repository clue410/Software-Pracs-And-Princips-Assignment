package groupProjectA_Mach1.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ProductDetail {
    @Id
    @GeneratedValue
    private long id;
    private String description;
    private String comment;
}
