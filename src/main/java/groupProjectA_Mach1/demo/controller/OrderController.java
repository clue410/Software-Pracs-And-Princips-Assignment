
package groupProjectA_Mach1.demo.controller;

import groupProjectA_Mach1.demo.model.Order;
import groupProjectA_Mach1.demo.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    private final OrderService orderService;

    //constructor
    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    //create new order
    @PostMapping("/order")
    Order createNewOrder(@RequestBody Order order) {
        Order newOrder = orderService.createNewOrder(order);
        return newOrder;
       // return ResponseEntity.ok("Order Created!");
    }

    //update order
    @PutMapping("/order/{id}")
    Order updateOrderDetails(@PathVariable Long id, @RequestBody Order order) {
//        order = orderService.findOrderById(id);
//        if (order != null) {
//            return orderService.updateOrder(id, order);
////            System.out.println("Order Not Found!");
//            //return ResponseEntity.ok("Order Not Found!");
//        }
//        else {
//            currentOrder = orderService.updateOrder(id, order);
//            //return ResponseEntity.ok("Order Updated!");
//        }
//        return currentOrder;
        return orderService.updateOrder(id, order);
    }
}
