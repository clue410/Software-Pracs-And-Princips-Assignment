package groupProjectB.demo.service.Listener;
import groupProjectB.demo.model.productEvent.ProductDetailEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ProductDetailEventListener implements ApplicationListener<ProductDetailEvent> {
    @Override
    public void onApplicationEvent(ProductDetailEvent event) {
        System.out.println("Received spring custom event - " + event.getMessage());
        System.out.println("RAHHH Product Detail Event Listener");
    }
}