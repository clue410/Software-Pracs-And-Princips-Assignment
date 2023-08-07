package groupProjectA_Mach1.demo.repository;

import groupProjectA_Mach1.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
