package model;
import javax.persistence.*;

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
