
package groupProjectB.demo.service;

import groupProjectB.demo.model.Customer;
import groupProjectB.demo.model.Order;
import groupProjectB.demo.model.Product;
import groupProjectB.demo.repository.OrderRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class OrderService {
    public static final String PRODUCT_URL = "http://localhost:8081/product/";
    public static final String CUSTOMER_URL = "http://localhost:8080/customer/";
    private final OrderRepository orderRepository;
    private final RestTemplate restTemplate;
    private final ApplicationEventPublisher applicationEventPublisher;

    public OrderService(OrderRepository orderRepository, RestTemplate restTemplate, ApplicationEventPublisher applicationEventPublisher){
        this.orderRepository = orderRepository;
        this.restTemplate = restTemplate;
        this.applicationEventPublisher = applicationEventPublisher;
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
    public long createNewOrder(Long productId, String supplier, int quantity, String status, Long customerId) {
        Order order = new Order();
        order.setSupplier(supplier);
        order.setProductId(restTemplate.getForObject(PRODUCT_URL + productId, Product.class).getId());
        order.setCustomerId(restTemplate.getForObject(CUSTOMER_URL + customerId, Customer.class).getId());
        order.setQuantity(quantity);
        order.setStatus(status);
        orderRepository.save(order);
        return order.getId();
    }

    //updating order
    public void updateOrder(Long id, Long productId, String supplier, int quantity, String status, Long customerId) {
        Order currentOrder = orderRepository.findById(id).get();
        currentOrder.setProductId(restTemplate.getForObject(PRODUCT_URL + productId, Product.class).getId());
        currentOrder.setCustomerId(restTemplate.getForObject(CUSTOMER_URL + customerId, Customer.class).getId());
        currentOrder.setSupplier(supplier);
        currentOrder.setQuantity(quantity);
        currentOrder.setStatus(status);
        orderRepository.save(currentOrder);
    }

    //buying order
    public void buyOrder(long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(RuntimeException::new);
        order.buy(orderId);
        order.setStatus("paid");
        orderRepository.save(order);
    }
}