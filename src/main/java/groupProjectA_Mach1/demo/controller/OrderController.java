
package groupProjectA_Mach1.demo.controller;

import groupProjectA_Mach1.demo.model.Order;
import groupProjectA_Mach1.demo.model.Product;
import groupProjectA_Mach1.demo.services.OrderService;
import groupProjectA_Mach1.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
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

    //create new order
    @PostMapping("/order")
    public ResponseEntity createNewOrder(@RequestBody Order order, Product product) {
        orderService.createNewOrder(order.supplier, order.product, order.quantity);
//        orderService.createNewOrder(order.supplier,product.getId(), order.quantity);
        return ResponseEntity.ok("Order Created!");
    }

    //update order
    @PutMapping("/order/{id}")
    public ResponseEntity updateOrder(@PathVariable Long id, @RequestBody Order currentOrder) {
        Order order = null;
        if (orderService.findOrderById(id) == null) {
            return ResponseEntity.ok("Order Not Found!");
        } else {
            orderService.updateOrder(id, order.supplier, order.quantity);
            return ResponseEntity.ok("Order Updated!");
        }
    }
}
