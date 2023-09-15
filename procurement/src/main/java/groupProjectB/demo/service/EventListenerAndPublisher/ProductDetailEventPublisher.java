package groupProjectB.demo.service.EventListenerAndPublisher;

import groupProjectB.demo.model.productEvent.ProductDetailEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class ProductDetailEventPublisher {
   @Autowired
   @Lazy
   private ProductDetailEventPublisher productDetailEventPublisher;

   public void publishProductDetailEvent(final String message){
       System.out.println("Product Detail Event Published!");
       ProductDetailEvent productDetailEvent = new ProductDetailEvent(this, message);
       productDetailEventPublisher.publishProductDetailEvent("Product Detail Event Published");
       System.out.println("Product Detail Event Publisher");
   }

}
