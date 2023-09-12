package groupProjectA_Mach1.demo.ProductEvent;

import org.springframework.context.ApplicationEvent;

import java.time.Clock;

public class ProductDetailEvent extends ApplicationEvent {
    private String eventMessage;

    public ProductDetailEvent(Object source, String eventMessage) {
        super(source);
        this.eventMessage = eventMessage;
    }

    public String getMessage() {
        return eventMessage;
    }
}