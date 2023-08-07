package groupProjectA_Mach1.demo.controller;

import groupProjectA_Mach1.demo.model.Product;
import groupProjectA_Mach1.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/product")
    void createProduct() {
        throw new RuntimeException("Not implemented");
    }

    @PutMapping("/product/{id}")
    void updateProduct(@PathVariable Long id) {
        throw new RuntimeException("Not implemented");
    }

    @GetMapping("/product/{id}")
    Product getProduct(@PathVariable Long id) {
        return productService.getById(id);
    }

    @PostMapping("/product/{id}/detail")
    void createProductDetail(@PathVariable Long id) {
        throw new RuntimeException("Not implemented");
    }

    @PutMapping("/product/{id}/detail")
    void updateProductDetail(@PathVariable Long id) {
        throw new RuntimeException("Not implemented");
    }

    @GetMapping("/product/{id}/detail")
    void getProductDetail(@PathVariable Long id) {
        throw new RuntimeException("Not implemented");
    }


}
