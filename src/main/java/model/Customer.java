package model;
import javax.persistence.*;

@Entity
public class Customer {

    @Id
    @GeneratedValue
    private long id;
    private String companyName;
    private String address;
    private String country;
}
