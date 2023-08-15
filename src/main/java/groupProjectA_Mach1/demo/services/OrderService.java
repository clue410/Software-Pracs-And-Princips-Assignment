
package groupProjectA_Mach1.demo.services;

import groupProjectA_Mach1.demo.model.Order;
import groupProjectA_Mach1.demo.model.Product;
import groupProjectA_Mach1.demo.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Set;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    //constructor
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    //find order by id
    public Order findOrderById(Long id) {
        if(orderRepository.existsById(id)) {
            return  orderRepository.findById(id).get();
        }
        else {
            return null;
        }
    }

    //create new order
    public Order createNewOrder(Order order) {
        Order newOrder = orderRepository.save(order);
        return newOrder;
    }

    //update order
    public Order updateOrder(Long id, Order order) {
        Order currentOrder = orderRepository.findById(id).get();
        currentOrder.setSupplier(order.getSupplier());
        currentOrder.setQuantity(order.getQuantity());
        currentOrder.setProduct(order.getProduct());
        return orderRepository.save(currentOrder);
    }
}

