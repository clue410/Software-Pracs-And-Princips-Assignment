package groupProjectA_Mach1.demo.ProductEvent;

import groupProjectA_Mach1.demo.model.Product;
import groupProjectA_Mach1.demo.services.ProductService;
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
//        List<Product> allProductsList = productService.getAllProducts();
//        Collections.sort(allProductsList, Collections.reverseOrder());
    }
}
