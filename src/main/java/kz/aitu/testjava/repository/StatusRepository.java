package kz.aitu.testjava.repository;

import kz.aitu.testjava.entity.OrderItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends CrudRepository<OrderItem,Long> {

}