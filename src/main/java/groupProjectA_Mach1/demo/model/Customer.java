package groupProjectA_Mach1.demo.model;

import javax.persistence.*;

@Entity
//@Component
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String companyName;
    private String address;
    private String country;
    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Contact contact;

    public Customer() {

    }

    public Customer(String companyName, String address, String country) {
        this.address = address;
        this.companyName = companyName;
        this.country = country;
    }

    public Customer(String companyName, String address, String country, Contact contact) {
        this.address = address;
        this.companyName = companyName;
        this.country = country;
        this.contact = contact;
    }

    public Contact getContact() {
        return this.contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return this.address;
    }


    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void print() {
        System.out.println("gijntjgntrng");
    }
}
