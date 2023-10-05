package csci318.demo.service;

import csci318.demo.model.event.OrderEvent;
import csci318.demo.model.event.ProductEvent;
import csci318.demo.repository.EventRepository;
import csci318.demo.repository.EventSource;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;

@Service
@EnableBinding(EventSource.class)
public class EventHandler {
    EventSource eventSource;
    EventRepository eventRepository;

    public EventHandler(EventSource eventSource){
        this.eventSource = eventSource;
    }

    @TransactionalEventListener
    public void handlePlacingOrder(OrderEvent orderEvent){
        eventSource.orderPlaced().send(MessageBuilder.withPayload(orderEvent).build());
        eventRepository.save(orderEvent);
    }

    @StreamListener(EventSource.STOCK_INPUT)
    public void receiveEvent(ProductEvent productEvent) {
        System.out.println("****READING FROM KAFKA TOPIC stock: "+
                productEvent.getStock()+"****");
    }
}
