
package groupProjectA_Mach1.demo.services;

import groupProjectA_Mach1.demo.model.Order;
import groupProjectA_Mach1.demo.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private ProductService productService;

    //constructor
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    //finding order
    public Order findOrderById(Long id) {
        if (orderRepository.existsById(id)) {
            return orderRepository.findById(id).get();
        } else {
            return null;
        }
    }

    //creating order
//    public long createNewOrder(String supplier, long productId, int quantity) {
//        Product product = productService.getById(productId);
//        Order order = new Order(supplier, id, quantity);
////        Order order = new Order(supplier,product.getId(), quantity);
//        Order newOrder = orderRepository.save(order);
//        return newOrder.getId();
//    }

    public long createNewOrder(String supplier) {
        Order createdEmptyOrder = new Order(supplier);
        orderRepository.save(createdEmptyOrder);
        return createdEmptyOrder.getId();
    }

    ;

    //updating order
    public void updateOrder(long id, long productId, String supplier, int quantity) {
        Order currentOrder = orderRepository.findById(id).get();
        currentOrder.setProductId(productId);
        currentOrder.setSupplier(supplier);
        currentOrder.setQuantity(quantity);
        orderRepository.save(currentOrder);
    }
//    public void addProductToOrder(long id,long productId, int quantity) {
//        Order currentOrder = orderRepository.findById(id).get();
//        currentOrder.setQuantity(quantity);
//        orderRepository.save(currentOrder);
//    }
}

