package kz.aitu.testjava.repository;

import kz.aitu.testjava.entity.CustomerOrder;
import org.springframework.core.annotation.Order;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CustomerOrderRepository extends CrudRepository<CustomerOrder, Long> {
    @Transactional
    @Modifying
    @Query(
            value = "SELECT id FROM customer_order  \n" +
                    "ORDER BY id DESC  \n" +
                    "LIMIT 1;  ",
            nativeQuery = true)
    int lastCustomerOrder();

    List<CustomerOrder> findAllByCustomerId(long customerId);

    List<Order> findAllByStatusId(Long statusId);

    Order findByToken(String token);
}

