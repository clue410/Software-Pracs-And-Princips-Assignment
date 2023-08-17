package groupProjectA_Mach1.demo.controller;

import groupProjectA_Mach1.demo.model.Product;
import groupProjectA_Mach1.demo.model.ProductDetail;
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
    ResponseEntity<String> createProduct(@RequestBody FormBackingProduct productForm) {
        System.out.println(productForm);
        productService.createNewProduct(productForm.productCategory, productForm.name, productForm.price);
        return new ResponseEntity<>("new product created --> category: " + productForm.productCategory + ", name: " + productForm.productCategory + ", price: " + productForm.price, HttpStatus.OK);
    }

    @PutMapping("/product/{id}")
    ResponseEntity<String> updateProduct(@PathVariable Long id, @RequestBody FormBackingProduct productForm) {
        Product product = productService.getById(id);
        if (product != null) {
            String oldName = product.getName();
            productService.updateProduct(id, productForm.productCategory, productForm.name, productForm.price);
            return new ResponseEntity<>("updated product:" + oldName + " --> " + productForm.name + "|" + "category: " + productForm.productCategory + ", name: " + productForm.productCategory + ", price: " + productForm.price, HttpStatus.OK);
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
    ResponseEntity<String> createProductDetail(@PathVariable Long id, @RequestBody FormBackingProductDetail productDetailForm) {
        Product product = productService.getById(id);
        ProductDetail productDetails = product.getProductDetails();
        if (productDetails != null) {
            return new ResponseEntity<>("Product " + product.getName() + "(" + product.getId() + ")" + " already has created details", HttpStatus.BAD_REQUEST);
        } else {
            ProductDetail productDetail = new ProductDetail(id, productDetailForm.description, productDetailForm.comment);
            product.setProductDetails(productDetail);
            productService.save(product);
            return new ResponseEntity<>("Product details created for " + product.getName() + "(" + product.getId() + ") | description: " + productDetailForm.description + ", comment: " + productDetailForm.comment, HttpStatus.OK);
        }
    }

    @PutMapping("/product/{id}/detail")
    ResponseEntity<String> updateProductDetail(@PathVariable Long id, @RequestBody FormBackingProductDetail productDetailForm) {
        Product product = productService.getById(id);
        ProductDetail productDetails = product.getProductDetails();
        if (productDetails != null) {
            productService.updateProductDetails(id, productDetailForm.description, productDetailForm.comment);
            productService.save(product);
            return new ResponseEntity<>("Updated Product details --> description: " + productDetailForm.description + ", comment: " + productDetailForm.comment, HttpStatus.OK);

        } else {
            return new ResponseEntity<>("Product " + product.getName() + "(" + product.getId() + ")" + " does not have details to update", HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/product/{id}/detail")
    ResponseEntity<Product> getProductDetail(@PathVariable Long id) {
        Product product = productService.getById(id);
        if (product.getProductDetails() != null) {
            return new ResponseEntity<Product>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<Product>(product, HttpStatus.BAD_REQUEST);
        }
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

    private static class FormBackingProductDetail {

        private String description;
        private String comment;

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        @Override
        public String toString() {
            return "FormBackingProductDetail{" +
                    "description='" + description + '\'' +
                    ", comment='" + comment + '\'' +
                    '}';
        }
    }
}
