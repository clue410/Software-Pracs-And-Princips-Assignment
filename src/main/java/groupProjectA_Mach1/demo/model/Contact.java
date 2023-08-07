package groupProjectA_Mach1.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Contact {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String phone;
    private String email;
    private String position;
}
