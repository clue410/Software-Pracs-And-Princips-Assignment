
package groupProjectA_Mach1.demo.repository;

import groupProjectA_Mach1.demo.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
