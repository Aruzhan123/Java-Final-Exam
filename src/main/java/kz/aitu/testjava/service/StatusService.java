package kz.aitu.testjava.service;


import kz.aitu.testjava.entity.OrderItem;
import kz.aitu.testjava.repository.StatusRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StatusService {
    private final StatusRepository statusRepository = null;



    public List<OrderItem> getAll() {
        return (List<OrderItem>) statusRepository.findAll();
    }

    public OrderItem save(OrderItem group) {
        return statusRepository.save(group);
    }
}