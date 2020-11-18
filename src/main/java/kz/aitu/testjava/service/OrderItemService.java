package kz.aitu.testjava.service;

import kz.aitu.testjava.entity.OrderItem;
import kz.aitu.testjava.repository.OrderItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderItemService {
    private OrderItemRepository orderItemRepository;



    public OrderItem save(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }
}
