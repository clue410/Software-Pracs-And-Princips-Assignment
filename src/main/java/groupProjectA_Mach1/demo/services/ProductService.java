package groupProjectA_Mach1.demo.services;

import groupProjectA_Mach1.demo.model.Product;
import groupProjectA_Mach1.demo.model.ProductDetail;
import groupProjectA_Mach1.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            return product.get();
        }
        return null;
    }

    public long createNewProduct(String category, String name, double price) {
        Product product = new Product(category, name, price);
        Product savedProduct = productRepository.save(product);
        return savedProduct.getId();
    }

    public void updateProduct(Long id, String productCategory, String name, double price) {
        Optional<Product> productOptional = productRepository.findById(id);
        Product product = productOptional.get();
        product.setProductCategory(productCategory);
        product.setName(name);
        product.setPrice(price);
        productRepository.save(product);
    }

    public void updateProductDetails(Long id, String description, String comment) {
        Optional<Product> productOptional = productRepository.findById(id);
        Product product = productOptional.get();
        ProductDetail productDetails = productOptional.get().getProductDetails();
        productDetails.setId(id);
        productDetails.setDescription(description);
        productDetails.setComment(comment);
        productRepository.save(product);
    }

    public void save(Product product) {
        productRepository.save(product);
    }
}
