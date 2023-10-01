package groupProjectB.demo.controller;

import groupProjectB.demo.model.Product;
import groupProjectB.demo.model.ProductDetail;
import groupProjectB.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import groupProjectB.demo.service.ProductKafka;
import org.springframework.web.bind.annotation.*;


import groupProjectB.demo.model.productEvent.ProductDetailEvent;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductController {

    private ProductService productService;
    private ProductKafka productKafka;

    public List<Product> getProductToSort() {
        return productService.getAllProducts()
                .stream()
                .map(product -> {
                    Product product1 = new Product();
                    product1.setName(product.getName());
                    product1.setProductCategory(product.getProductCategory());
                    product1.setProductDetails(product.getProductDetails());
                    product1.setPrice(product.getPrice());
                    product1.setId(product.getId());
                    return product1;
                }).collect(Collectors.toList());
    }

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/product")
    ResponseEntity<String> createProduct(@RequestBody FormBackingProduct productForm) {
        System.out.println(productForm);
        productService.createNewProduct(productForm.productCategory, productForm.name, productForm.price, productForm.stock);
        return new ResponseEntity<>("new product created --> category: " + productForm.productCategory + ", name: " + productForm.name + ", price: " + productForm.price + ", stock: " + productForm.stock, HttpStatus.OK);
    }

    @PutMapping("/product/{id}")
    ResponseEntity<String> updateProduct(@PathVariable Long id, @RequestBody FormBackingProduct productForm) {
        Product product = productService.getById(id);
        if (product != null) {
            String oldName = product.getName();
            productService.updateProduct(id, productForm.productCategory, productForm.name, productForm.price, productForm.stock);
            return new ResponseEntity<>("updated product:" + oldName + " --> " + productForm.name + "|" + "category: " + productForm.productCategory + ", name: " + productForm.productCategory + ", price: " + productForm.price + ", stock: " + productForm.stock, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/products")
    List<Product> allProductsAndDetails() {
        return productService.getAllProducts()
                .stream()
                .map(product -> {
                    Product product1 = new Product();
                    product1.setName(product.getName());
                    product1.setProductCategory(product.getProductCategory());
                    product1.setProductDetails(product.getProductDetails());
                    product1.setPrice(product.getPrice());
                    product1.setStock(product.getStock());
                    product1.setId(product.getId());
                    return product1;
                }).collect(Collectors.toList());
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

    @GetMapping("/product/{id}/stock")
    ResponseEntity<Integer> getProductStock(@PathVariable Long id) {
        Product product = productService.getById(id);
        if (product.getStock() <= 0) {
            return new ResponseEntity<>(product.getStock(), HttpStatus.NOT_ACCEPTABLE);
        } else {
            return new ResponseEntity<>(product.getStock(), HttpStatus.OK);
        }
    }

    //works
    @PostMapping("/product/{productId}/detail")
    ResponseEntity<String> createProductDetail(@PathVariable Long productId, @RequestBody FormBackingProductDetail
            productDetailForm) {
        Product product = productService.getById(productId);
        if (product.getProductDetails() != null) {
            return new ResponseEntity<>("Product " + product.getName() + "(" + product.getId() + ")" + " already has created details", HttpStatus.BAD_REQUEST);
        } else {
            ProductDetail productDetail = new ProductDetail(productId, productDetailForm.comment, productDetailForm.description);
            product.setProductDetails(productDetail);
            productService.save(product);
            return new ResponseEntity<>("Product details created for " + product.getName() + "(" + product.getId() + ") | description: " + productDetailForm.description + ", comment: " + productDetailForm.comment, HttpStatus.OK);
        }
    }

    //works
    @PutMapping("/product/{productId}/detail")
    ResponseEntity<String> updateProductDetail(@PathVariable Long productId, @RequestBody FormBackingProductDetail
            productDetailForm) {
        Product product = productService.getById(productId);
        if (product.getProductDetails() != null) {
            productService.updateProductDetails(productId, productDetailForm.comment, productDetailForm.description);
            return new ResponseEntity<>("Updated Product details --> description: " + productDetailForm.description + ", comment: " + productDetailForm.comment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Product " + product.getName() + "(" + product.getId() + ")" + " does not have details to update", HttpStatus.BAD_REQUEST);
        }
    }

    //works
    @GetMapping("/product/{id}/detail")
    ResponseEntity<Product> getProductDetail(@PathVariable Long id) {
        Product product = productService.getById(id);
        if (product.getProductDetails() != null) {
            return new ResponseEntity<Product>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<Product>(product, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/products/sort")
    List<Product> sortByPriceEVENT() {
        ProductDetailEvent productDetailEvent = new ProductDetailEvent(this, "woogoo");
        List<Product> productList = allProductsAndDetails();
//        List<Product> productList = allProductsAndDetails();
        return productDetailEvent.eventSortByPriceAsc(productList);
    }

    @GetMapping(value = "/kafkaTest")
    public String producer(@RequestParam("message") Product product) {
        productKafka.send(product);
        return "Sent product to Product Kafka ";
    }

    private static class FormBackingProduct {
        private String productCategory;
        private String name;
        private double price;
        private int stock;

        @Override
        public String toString() {
            return "ProductForm{" +
                    "productCategory='" + productCategory + '\'' +
                    ", name='" + name + '\'' +
                    ", price=" + price + '\'' +
                    ", stock=" + stock +
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

        public int getStock() {
            return stock;
        }

        public void setStock(int stock) {
            this.stock = stock;
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

