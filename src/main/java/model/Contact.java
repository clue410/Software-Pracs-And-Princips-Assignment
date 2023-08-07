package model;
import javax.persistence.*;

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
