package groupProjectA_Mach1.demo.services;

import groupProjectA_Mach1.demo.model.Product;
import groupProjectA_Mach1.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    List<Product> findProductsByBlah() {
        return productRepository.findAll();//todo real stuff
    }

    public Product getById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            return product.get();
        }
        return null;
    }
}
