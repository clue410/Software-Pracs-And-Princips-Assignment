package groupProjectA_Mach1.demo.services;

import com.example.demo.model.Order;
import com.example.demo.model.Product;
import com.example.demo.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    //constructor
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    //finding order
    public Order findOrderById(Long id) {
        if(orderRepository.existsById(id)) {
            return  orderRepository.findById(id).get();
        }
        else {
            return null;
        }
    }

    //creating order
    public long createNewOrder(String supplier, Product product, int quantity) {
        Order order = new Order(supplier, product, quantity);
        Order newOrder = orderRepository.save(order);
        return newOrder.getId();
    }

    //updating order
    public void updateOrder(long id, String supplier, Product product, int quantity) {
        Order currentOrder = orderRepository.findById(id).get();
        currentOrder.setSupplier(supplier);
        currentOrder.setProduct(product);
        currentOrder.setQuantity(quantity);
        orderRepository.save(currentOrder);
    }
}
