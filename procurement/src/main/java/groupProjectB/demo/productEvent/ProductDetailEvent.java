package groupProjectB.demo.productEvent;
import groupProjectB.demo.model.Product;
import groupProjectB.demo.service.ProductService;
import org.springframework.context.ApplicationEvent;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.Clock;
import java.util.*;
import java.util.stream.Collectors;

public class ProductDetailEvent extends ApplicationEvent {
    private String eventMessage;
    private ProductService productService;

    public ProductDetailEvent(Object source, String eventMessage) {
        super(source);
        this.eventMessage = eventMessage;
        System.out.println("RAHHH Product Detail Event");
    }

    public String getMessage() {
        return eventMessage;
    }

    public void eventSortByPriceAsc() {
        System.out.println("RAHHH SORT");
//        List<Product> allProductsLisst = productService.getAllProducts();
//        Collections.sort(allProductsList, Collections.reverseOrder());
    }
    public void getAll(){

    }
}
