
package groupProjectB.demo.controller;

import groupProjectB.demo.controller.dto.OrderDTO;
import groupProjectB.demo.model.Order;
import groupProjectB.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        String status = orderDTO.getStatus();
        Long customerId = orderDTO.getCustomerId();
        orderService.createNewOrder(productId, supplier, quantity, status, customerId);
        return ResponseEntity.ok("New order created --> customerId: " + customerId + ", productId: " + productId + ", supplier: " + supplier + ", quantity: " + quantity + ", status: " + status);
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
            String status = orderDTO.getStatus();
            Long customerId = orderDTO.getCustomerId();
            orderService.updateOrder(orderId, productId, supplier, quantity, status, customerId);
            return ResponseEntity.ok("Order updated --> orderId: " + orderId + ", customerId: " + customerId + ", productId: " + productId + ", supplier: " + supplier + ", quantity: " + quantity + ", status: " + status);
        }
    }

    //finding an order
    @GetMapping("/order/{orderId}")
        ResponseEntity getOrder(@PathVariable Long orderId) {
        Order order = orderService.findOrderById(orderId);
        if (order != null) {
            return new ResponseEntity<Order>(order, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //finding all orders
//    @GetMapping("/order")
//    List<OrderDTO> getAllOrders() {
//        List<Order> orders = orderService.getAllOrders();
//        List<OrderDTO> orderDTOList = new ArrayList<>();
//
//        for (Order order : orders) {
//            OrderDTO orderDTO = new OrderDTO();
//            orderDTO.setProductId(order.getProductId());
//            orderDTO.setSupplier(order.getSupplier());
//            orderDTO.setQuantity(order.getQuantity());
//            orderDTO.setStatus(order.getStatus());
//            orderDTO.setId(order.getId());
//            orderDTOList.add(orderDTO);
//        }
//
//        return orderDTOList;
//    }

    @GetMapping("/order")
    List<Order> getAllOrders() {
        return orderService.getAllOrders()
                .stream()
                .map(order -> {
                    Order order1 = new Order();
                    order1.setProductId(order.getProductId());
                    order1.setSupplier(order.getSupplier());
                    order1.setQuantity(order.getQuantity());
                    order1.setStatus(order.getStatus());
                    order1.setCustomerId(order.getCustomerId());
                    order1.setId(order.getId());
                    return order1;
                }).collect(Collectors.toList());
    }

    //buying an order
    @PutMapping("/order/buy/{orderId}")
    ResponseEntity buyOrder(@PathVariable Long orderId) {
        Order order = orderService.findOrderById(orderId);
        orderService.buyOrder(orderId);
        return new ResponseEntity<Order>(order, HttpStatus.OK);
    }
}
