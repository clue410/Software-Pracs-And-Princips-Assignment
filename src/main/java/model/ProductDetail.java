package model;
import javax.persistence.*;

@Entity

public class ProductDetail {
    @Id
    @GeneratedValue
    private long id;

    private String description;
    private String comment;
}
