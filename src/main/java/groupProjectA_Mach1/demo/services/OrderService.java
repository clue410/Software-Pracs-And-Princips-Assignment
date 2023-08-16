
package groupProjectA_Mach1.demo.services;

import groupProjectA_Mach1.demo.model.Order;
import groupProjectA_Mach1.demo.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    //constructor
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    //find order by id
    public Order findOrderById(Long id) {
//        if(orderRepository.existsById(id)) {
//            return  orderRepository.findById(id).get();
//        }
//        else {
//            return null;
//        }
        Order order = orderRepository.findById(id).orElseThrow(RuntimeException::new);
        return order;
    }

    //create new order
    public Order createNewOrder(Order order) {
        Order newOrder = orderRepository.save(order);
        return newOrder;
    }

    //update order
    public Order updateOrder(Long id, Order order) {
        Order updatedOrder = orderRepository.findById(id).get();
        updatedOrder.setSupplier(order.getSupplier());
        updatedOrder.setQuantity(order.getQuantity());
        updatedOrder.setProduct(order.getProduct());
        return orderRepository.save(updatedOrder);
    }
}

