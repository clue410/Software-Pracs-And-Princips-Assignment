package groupProjectA_Mach1.demo.controller;
import model.Order;
import repository.OrderRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController

public class OrderController {

//    private final BookRepository bookRepository;
//
//    BookController(BookRepository bookRepository) {
//        this.bookRepository= bookRepository;
//    }
//
//    @GetMapping("/books")
//    List<Book> all() {
//        return bookRepository.findAll();
//    }
//
//    @PostMapping("/books")
//    Book newBook(@RequestBody Book newBook) {
//        return bookRepository.save(newBook);
//    }
}
