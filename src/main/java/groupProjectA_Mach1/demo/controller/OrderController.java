
package groupProjectA_Mach1.demo.controller;

import groupProjectA_Mach1.demo.services.OrderService;
import groupProjectA_Mach1.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    private final OrderService orderService;
    private final ProductService productService;

    //constructor
    @Autowired
    public OrderController(OrderService orderService, ProductService productService) {
        this.orderService = orderService;
        this.productService = productService;
    }

    @PostMapping("/order")
    public ResponseEntity createNewOrder(@RequestBody FormBackingOrderUpdate formBackingOrderUpdate) {
        String supplier = formBackingOrderUpdate.supplier;
        orderService.createNewOrder(supplier);
//        orderService.createNewOrder(order.supplier,product.getId(), order.quantity);
        return ResponseEntity.ok("New order created --> supplier:" + supplier);
    }

    //    update order
    @PutMapping("/order/{orderId}")
    public ResponseEntity updateOrder(@PathVariable Long orderId, @RequestBody FormBackingOrderUpdate formBackingOrderUpdate) {
        if (orderService.findOrderById(orderId) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            long productId = formBackingOrderUpdate.productId;
            String supplier = formBackingOrderUpdate.supplier;
            int quantity = formBackingOrderUpdate.quantity;
            orderService.updateOrder(orderId, productId, supplier, quantity);
            return new ResponseEntity<>("Product added to order(" + orderId + ")" + "productId: " + productId + ", supplier: " + supplier + ", quantity: " + quantity, HttpStatus.OK);

        }
    }

    private static class FormBackingOrderUpdate {
        private long productId;

        private String supplier;
        private int quantity;

        public String getSupplier() {
            return supplier;
        }

        public void setSupplier(String supplier) {
            this.supplier = supplier;
        }

        public long getProductId() {
            return productId;
        }

        public void setProductId(long productId) {
            this.productId = productId;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        @Override
        public String toString() {
            return "FormBackingOrderUpdate{" +
                    "productId=" + productId +
                    ", supplier='" + supplier + '\'' +
                    ", quantity=" + quantity +
                    '}';
        }
    }

}
