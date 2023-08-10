package groupProjectA_Mach1.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "orders")
public class Order {
    @Id
    @GeneratedValue
    private long id;
    private String supplier;
    private String product;
    private int quantity;


}
