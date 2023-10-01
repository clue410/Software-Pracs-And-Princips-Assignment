package csci318.demo.controller;

import csci318.demo.model.Contact;
import csci318.demo.model.Customer;
import csci318.demo.model.CustomerEvent.ContactEvent;
import csci318.demo.service.CustomerService;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    private CustomerService cusService;

    public List<Customer> getCustomerToSort() {
        return cusService.getAllCustomers()
                .stream()
                .map(customer -> {
                    Customer cus1 = new Customer();
                    cus1.setAddress(cus1.getAddress());
                    cus1.setCompanyName(cus1.getCompanyName());
                    cus1.setCountry(cus1.getCountry());
                    cus1.setId(cus1.getId());
                    return cus1;
                }).collect(Collectors.toList());
    }

    @Autowired
    public CustomerController(CustomerService cusService) {
        this.cusService = cusService;
    }

    @PostMapping("/customer")
    ResponseEntity<String> createCustomer(@RequestBody FormBackingCustomer customerForm) {
        System.out.println(customerForm);
        cusService.createCustomer(customerForm.companyName, customerForm.address, customerForm.country);
        return new ResponseEntity<>("new customer created -->  company Name:" + customerForm.companyName + ",address: " + customerForm.address + ",country: " + customerForm.country, HttpStatus.OK);
    }

    @PutMapping("/customer/{id}")
    ResponseEntity<String> updateCustomer(@PathVariable Long id, @RequestBody FormBackingCustomer customerForm) {
        Customer customer = cusService.findCus(id);
        if (customer != null) {
            String oldName = customer.getCompanyName();
            cusService.updateCustomer(id, customerForm.companyName, customerForm.address, customerForm.country);
            return new ResponseEntity<>("updated customer:" + oldName + " --> " + customerForm.companyName + ",address: " + customerForm.address + ",country: " + customerForm.country, HttpStatus.OK);
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
        if (customer.getContact() != null) {
            return new ResponseEntity<>("Customer " + customer.getContact().getContactValueObject().getName() + "(" + customer.getId() + ")" + " already has created details", HttpStatus.BAD_REQUEST);
        } else {
            Contact con = new Contact(id, contactForm.name, contactForm.phone, contactForm.email, contactForm.position);
            customer.setContact(con);
            cusService.save(customer);
            return new ResponseEntity<>("Contact created for " + con.getContactValueObject().getName() + "(" + customer.getId() + ") --> phone: " + contactForm.phone + ",email: " + contactForm.email + ",position: " + contactForm.position, HttpStatus.OK);
        }
    }

    @PutMapping("/customer/{id}/contact")
    ResponseEntity<String> updateContactDetail(@PathVariable Long id, @RequestBody FormBackingContact contactForm) {
        Customer customer = cusService.findCus(id);
        Contact contact = customer.getContact();
        if (contact != null) {
            cusService.updateContact(id, contactForm.name, contactForm.phone, contactForm.email, contactForm.position);
            cusService.save(customer);
            return new ResponseEntity<>("Contact updated -->" + "updated name:" + contactForm.name + ",phone: " + contactForm.phone + ",email: " + contactForm.email + ",position: " + contactForm.position, HttpStatus.OK);

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

    @GetMapping("/customers")
    List<Customer> allCustomers() {
        return cusService.getAllCustomers()
                .stream()
                .map(customer -> {
                    Customer cus1 = new Customer();
                    cus1.setAddress(customer.getAddress());
                    cus1.setCompanyName(customer.getCompanyName());
                    cus1.setCountry(customer.getCountry());
                    cus1.setId(customer.getId());
                    cus1.setContact(customer.getContact());
                    return cus1;
                }).collect(Collectors.toList());
    }

    @GetMapping("/customers/sort")
    List<Customer> sortByCountryEVENT() {
        ContactEvent contactEventEvent = new ContactEvent(this, "woogoo");
        List<Customer> cus = allCustomers();
        return ContactEvent.eventSortByCountryAsc(cus);
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

    }
}
