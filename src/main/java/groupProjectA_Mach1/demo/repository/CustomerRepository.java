package groupProjectA_Mach1.demo.repository;

import groupProjectA_Mach1.demo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
