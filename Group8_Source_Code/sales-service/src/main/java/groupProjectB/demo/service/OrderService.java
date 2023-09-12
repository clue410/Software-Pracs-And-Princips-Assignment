
package groupProjectB.demo.service;

import groupProjectB.demo.model.Order;
import groupProjectB.demo.model.Product;
import groupProjectB.demo.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final RestTemplate restTemplate;

    public OrderService(OrderRepository orderRepository, RestTemplate restTemplate){
        this.orderRepository = orderRepository;
        this.restTemplate = restTemplate;
    }

    //finding an order
    public Order findOrderById(Long id) {
        if (orderRepository.existsById(id)) {
            return orderRepository.findById(id).get();
        } else {
            return null;
        }
    }

    //finding all orders
    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    //creating order
    public long createNewOrder(Long productId, String supplier, int quantity) {
        String url = "http://localhost:8081/product/";
        Order order = new Order();
        order.setSupplier(supplier);
        order.setProductId(restTemplate.getForObject(url + productId, Product.class).getId());
        order.setQuantity(quantity);
        orderRepository.save(order);
        return order.getId();
    }

    //updating order
    public void updateOrder(Long id, Long productId, String supplier, int quantity) {
        Order currentOrder = orderRepository.findById(id).get();
        String url = "http://localhost:8081/product/";
        currentOrder.setProductId(restTemplate.getForObject(url + productId, Product.class).getId());
        currentOrder.setSupplier(supplier);
        currentOrder.setQuantity(quantity);

        orderRepository.save(currentOrder);
    }

//    public List<Order> findCustomerOrders(Long cusId) {
//        String url = "http://localhost:8082/order/";
//        List<Order> orders = new ArrayList<>();
//        List<Long> orderIds = orderRepository.findById(cusId).orElseThrow(RuntimeException::new).getOrders();
//
//        for (Long id : orderIds) {
//            orders.add(restTemplate.getForObject(url + id, Order.class));
//        }
//        return orders;
//    }
}

