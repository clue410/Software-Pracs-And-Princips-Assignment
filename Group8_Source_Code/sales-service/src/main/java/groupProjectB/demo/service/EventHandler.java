package groupProjectB.demo.service;

import groupProjectB.demo.model.event.OrderEvent;
import groupProjectB.demo.repository.EventRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;

@Service
public class EventHandler {
    private final EventRepository eventRepository;

    EventHandler(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    //buying order transactional event listener
    @TransactionalEventListener
    public void handleBuying(OrderEvent orderEvent){
        eventRepository.save(orderEvent);
    }
}
