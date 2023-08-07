package groupProjectA_Mach1.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {

    @Id
    @GeneratedValue
    private long id;
    private String productCategory;
    private String name;
    private double price;

    public Product() {
    }

    //getters, setters blah blah blah

}
