package csci318.demo.service;

import csci318.demo.model.Product;
import csci318.demo.repository.EventSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;

@Service
@EnableBinding(EventSource.class)
public class ProductKafka {
//    @Autowired
//    private KafkaTemplate<Object, Product> kafkaTemplate;
//    String kafkaTopic = "Product";
//
//    public void send(Product product) {
//        kafkaTemplate.send(kafkaTopic, product);
//    }

    EventSource eventSource;

    public ProductKafka(EventSource eventSource){
        this.eventSource = eventSource;
    }

    @TransactionalEventListener
    public void send(Product product){
        eventSource.productStock().send(MessageBuilder.withPayload(product).build());
    }
}
