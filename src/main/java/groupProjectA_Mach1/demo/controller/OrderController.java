package groupProjectA_Mach1.demo.controller;

import com.example.demo.model.Order;
import com.example.demo.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    private final OrderService orderService;

    //constructor
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    //create new order
    @PostMapping("/order")
    public ResponseEntity createNewOrder(@RequestBody Order order) {
        //return orderService.createNewOrder(order.supplier, order.product, order.quantity);
        orderService.createNewOrder(order.supplier, order.product, order.quantity);
        return ResponseEntity.ok("Order Created!");
    }

    //update order
    @PutMapping("/order/{id}")
    public ResponseEntity updateOrder(@PathVariable Long id, @RequestBody Order currentOrder) {
        Order order = null;
        if (orderService.findOrderById(id) == null) {
            return ResponseEntity.ok("Order Not Found!");
        } 
        else {
            orderService.updateOrder(id, order.supplier, order.product, order.quantity);
            return ResponseEntity.ok("Order Updated!");
        }
    }
}
