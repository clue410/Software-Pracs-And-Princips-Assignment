package groupProjectA_Mach1.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

import groupProjectA_Mach1.demo.model.Contact;
import groupProjectA_Mach1.demo.model.Customer;
import groupProjectA_Mach1.demo.model.Product;
import groupProjectA_Mach1.demo.model.ProductDetail;
import groupProjectA_Mach1.demo.services.CustomerService;

@RestController
public class CustomerController {

    private CustomerService cusService;

    @Autowired
    public CustomerController(CustomerService cusService){
        this.cusService=cusService;
    }

   @PostMapping("/customer")
    ResponseEntity<String> createCustomer(@RequestBody FormBackingCustomer customerForm) {
        System.out.println(customerForm);
        cusService.createCustomer(customerForm.companyName, customerForm.address, customerForm.country, customerForm.contact);
        return new ResponseEntity<>("new customer created : " + customerForm.contact.getName(), HttpStatus.OK);
    }

    @PutMapping("/customer/{id}")
    ResponseEntity<String> updateCustomer(@PathVariable Long id, @RequestBody FormBackingCustomer customerForm) {
        Customer customer = cusService.findCus(id);
        if (customer != null) {
          //  String oldName = customer.getName();
            cusService.updateCustomer(id, customerForm.companyName, customerForm.address, customerForm.country);
            return new ResponseEntity<>("updated customer:"+ " --> " + customerForm.contact.getName(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/customer/{id}")
    ResponseEntity<Customer> getCustomer(@PathVariable Long id) {
        Customer customer = cusService.findCus(id);
        if (customer != null) {
            return new ResponseEntity<Customer>(customer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/customer/{id}/contact")
    ResponseEntity<String> createContactDetail(@PathVariable Long id, @RequestBody FormBackingContact contactForm) {
        Customer customer = cusService.findCus(id);
        Contact contact = customer.getContact();
        if (contact != null) {
            return new ResponseEntity<>("Customer " + contact.getName() + "(" + customer.getId() + ")" + " already has created details", HttpStatus.BAD_REQUEST);
        } else {
            Contact con = new Contact(id, contactForm.name, contactForm.phone, contactForm.email, contactForm.position);
            customer.setContact(con);
            cusService.save(customer);
            return new ResponseEntity<>("Contact created for " + con.getName() + "(" + customer.getId() + ")", HttpStatus.OK);
        }
    }

    @PutMapping("/customer/{id}/contact")
    ResponseEntity<String> updateContactDetail(@PathVariable Long id, @RequestBody FormBackingContact contactForm) {
        Customer customer = cusService.findCus(id);
        Contact contact = customer.getContact();
        if (contact != null) {
            cusService.updateContact(id, contactForm.name, contactForm.phone, contactForm.email, contactForm.position);
            cusService.save(customer);
            return new ResponseEntity<>(HttpStatus.OK);

        } else {
            return new ResponseEntity<>("Customer does not have details to update", HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/customer/{id}/contact")
    ResponseEntity<Customer> getContactDetail(@PathVariable Long id) {
        Customer customer = cusService.findCus(id);
        if (customer.getContact() != null) {
            return new ResponseEntity<Customer>(customer, HttpStatus.OK);
        } else {
            return new ResponseEntity<Customer>(customer, HttpStatus.BAD_REQUEST);
        }
    }


    private static class FormBackingCustomer {
        private String companyName;
        private String address;
        private String country;
        private Contact contact;

        public Contact getContact() {
            return this.contact;
        }
    
        public void setContact(Contact contact) {
            this.contact = contact;
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

        // @Override
        // public String toString() {
        //     return "ProductForm{" +
        //             "productCategory='" + productCategory + '\'' +
        //             ", name='" + name + '\'' +
        //             ", price=" + price +
        //             '}';
        // }

 
    }

    private static class FormBackingContact {

        private long id;
    private String name;
    private String phone;
    private String email;
    private String position;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

        // @Override
        // public String toString() {
        //     return "FormBackingProductDetail{" +
        //             "description='" + description + '\'' +
        //             ", comment='" + comment + '\'' +
        //             '}';
        // }
    }
   

}
