package groupProjectA_Mach1.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Customer {

    @Id
    @GeneratedValue
    private long id;
    private String companyName;
    private String address;
    private String country;
}
