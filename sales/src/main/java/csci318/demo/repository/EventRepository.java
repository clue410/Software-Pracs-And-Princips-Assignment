package csci318.demo.repository;

import csci318.demo.model.event.OrderEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<OrderEvent, Long> {

}