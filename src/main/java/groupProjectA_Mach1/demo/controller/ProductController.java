package groupProjectA_Mach1.demo.controller;

import groupProjectA_Mach1.demo.model.Product;
import groupProjectA_Mach1.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/product")
    long createProduct(@RequestBody FormBackingProduct productForm) {
        System.out.println(productForm);
        return productService.createNewProduct(productForm.productCategory, productForm.name, productForm.price);
    }

    @PutMapping("/product/{id}")
    ResponseEntity<String> updateProduct(@PathVariable Long id, @RequestBody FormBackingProduct productForm) {
        Product product = productService.getById(id);
        if (product != null) {
            productService.updateProduct(id, productForm.productCategory, productForm.name, productForm.price);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/product/{id}")
    ResponseEntity<Product> getProduct(@PathVariable Long id) {
        Product product = productService.getById(id);
        if (product != null) {
            return new ResponseEntity<Product>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
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


    private static class FormBackingProduct {
        private String productCategory;
        private String name;
        private double price;

        @Override
        public String toString() {
            return "ProductForm{" +
                    "productCategory='" + productCategory + '\'' +
                    ", name='" + name + '\'' +
                    ", price=" + price +
                    '}';
        }

        public String getProductCategory() {
            return productCategory;
        }

        public void setProductCategory(String productCategory) {
            this.productCategory = productCategory;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }

    /*

    {
     "productCategory": "food",
     "name": "milk",
     "price": 3.40
}
     */
}
