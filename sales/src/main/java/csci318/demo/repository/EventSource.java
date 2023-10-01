package csci318.demo.repository;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface EventSource {
    @Output("orderPlacedChannel")
    MessageChannel orderPlaced();
}
