package groupProjectB.demo.service;

import groupProjectB.demo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProductKafka {
    @Autowired
    private KafkaTemplate<Object, Product> kafkaTemplate;
    String kafkaTopic = "Product";

    public void send(Product product) {

        kafkaTemplate.send(kafkaTopic, product);
    }
}