package groupProjectB.demo.repository;

import groupProjectB.demo.model.event.OrderEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<OrderEvent, Long> {

}
