package model;
import javax.persistence.*;

@Entity
public class Order {

    @Id
    @GeneratedValue
    private long id;
    private String supplier;
    private String product;
    private int quantity;


}
