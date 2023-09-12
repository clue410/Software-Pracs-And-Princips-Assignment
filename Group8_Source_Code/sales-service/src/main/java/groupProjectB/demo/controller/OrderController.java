
package groupProjectB.demo.controller;

import groupProjectB.demo.controller.dto.OrderDTO;
import groupProjectB.demo.model.Order;
import groupProjectB.demo.model.Product;
import groupProjectB.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class OrderController {
    private final OrderService orderService;

    //constructor
    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    //creating order
    @PostMapping("/order")
    public ResponseEntity createNewOrder(@RequestBody OrderDTO orderDTO) {
        String supplier = orderDTO.getSupplier();
        Long productId = orderDTO.getProductId();
        int quantity = orderDTO.getQuantity();
        orderService.createNewOrder(productId, supplier, quantity);
        return ResponseEntity.ok("New order created --> productId: " + productId + ", supplier: " + supplier + ", quantity: " + quantity);
    }

    //updating order
    @PutMapping("/order/{orderId}")
    public ResponseEntity updateOrder(@PathVariable Long orderId, @RequestBody OrderDTO orderDTO) {
        if (orderService.findOrderById(orderId) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            Long productId = orderDTO.getProductId();
            String supplier = orderDTO.getSupplier();
            int quantity = orderDTO.getQuantity();
            orderService.updateOrder(orderId, productId, supplier, quantity);
            return ResponseEntity.ok("Order updated --> orderId: " + orderId + ", productId: " + productId + ", supplier: " + supplier + ", quantity: " + quantity);
        }
    }

    //getting a specific order
//    @GetMapping("/order/{orderId}")
//    ResponseEntity<Order> getOrder(@PathVariable long id) {
//        Order order = orderService.findOrderById(id);
//        if (order != null) {
//            return new ResponseEntity<Order>(order, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

    //finding an order
    @GetMapping("/order/{orderId}")
        ResponseEntity<Order> getOrder(@PathVariable Long orderId) {
        Order order = orderService.findOrderById(orderId);
        if (order != null) {
            return new ResponseEntity<Order>(order, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //finding all orders
    @GetMapping("/order")
    List<OrderDTO> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        List<OrderDTO> orderDTOList = new ArrayList<>();

        for (Order order : orders) {
            OrderDTO orderDTO = new OrderDTO();
            orderDTO.setProductId(order.getProductId());
            orderDTO.setSupplier(order.getSupplier());
            orderDTO.setQuantity(order.getQuantity());
            orderDTOList.add(orderDTO);
        }

        return orderDTOList;
    }

}
