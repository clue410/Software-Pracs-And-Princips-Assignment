package groupProjectB.demo.service;

import groupProjectB.demo.model.Contact;
import groupProjectB.demo.model.Customer;
import groupProjectB.demo.repository.CustomerRepository;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository cusRepo;

    public CustomerService(CustomerRepository cusRepo) {
        this.cusRepo = cusRepo;
    }

    //finding customer
    public Customer findCus(long id) {
        if (cusRepo.existsById(id)) {
            return cusRepo.findById(id).get();
        } else {
            return null;
        }
    }

    //saving customer
    public void save(Customer cus) {
        cusRepo.save(cus);
    }

    //creating customer
    public long createCustomer(String companyName, String address, String country) {

        Customer cus = new Customer(companyName, address, country);

        cusRepo.save(cus);

        return cus.getId();
    }

    //updating customer
    public void updateCustomer(long id, String companyName, String address, String country) {

        Customer cus = cusRepo.findById(id).get();

        cus.setAddress(address);
        cus.setCompanyName(companyName);
        cus.setCountry(country);

        cusRepo.save(cus);

    }

    //finding contact
    public Contact findContact(long id) {
        if (cusRepo.existsById(id)) {
            return cusRepo.findById(id).get().getContact();
        } else {
            return null;
        }
    }

    //creating contact
    public long createContact(long id, String name, String phone, String email, String position) {

        Contact contact = new Contact(id, name, phone, email, position);

        Customer cus = findCus(id);

        cus.setContact(contact);

        cusRepo.save(cus);

        return cus.getId();
    }

    //updating contact
    public long updateContact(long id, String name, String phone, String email, String position) {

        Customer cus = findCus(id);

        Contact contact = cus.getContact();

        contact.setEmail(email);
        contact.setId(id);
        contact.setName(name);
        contact.setPhone(phone);
        contact.setPosition(position);

        cus.setContact(contact);

        cusRepo.save(cus);

        return cus.getId();
    }

    public List<Customer> getAllCustomers(){
        return cusRepo.findAll();
    }
}
