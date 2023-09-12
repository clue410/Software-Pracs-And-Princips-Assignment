package groupProjectA_Mach1.demo.services;

import groupProjectA_Mach1.demo.model.Product;
import groupProjectA_Mach1.demo.model.ProductDetail;
import groupProjectA_Mach1.demo.repository.ProductRepository;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.stereotype.Service;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService{

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
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public void updateProductDetails(Long productId, String comment, String description) {
        Optional<Product> productOptional = productRepository.findById(productId);
//        if (productOptional.isPresent()) {
        Product product = productOptional.get();
        ProductDetail productDetails = productOptional.get().getProductDetails();

        productDetails.getProductDetailValueObject().setComment(comment);
        productDetails.getProductDetailValueObject().setDescription(description);
        productRepository.save(product);
//        }
    }

    public void save(Product product) {
        productRepository.save(product);
    }
}
//get all

//@Entity
//public class Aggregate3 extends AbstractAggregateRoot<Aggregate3> {
//    // ...
//    public void domainOperation() {
//        // some domain operation
//        registerEvent(new DomainEvent());
//    }
//}


//Aggregates V V V
//public class Cargo extends AbstractAggregateRoot<Cargo> {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

//@Embeddable
//public class BookingId implements Serializable {