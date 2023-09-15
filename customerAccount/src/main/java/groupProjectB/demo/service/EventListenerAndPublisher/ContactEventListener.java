package groupProjectB.demo.service.EventListenerAndPublisher;
import groupProjectB.demo.model.CustomerEvent.ContactEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component("bruh")
public class ContactEventListener implements ApplicationListener<ContactEvent> {
    @Override
    public void onApplicationEvent(ContactEvent event) {
        System.out.println("Received spring custom event - " + event.getMessage());
        System.out.println("RAHHH Product Detail Event Listener");
    }
}

