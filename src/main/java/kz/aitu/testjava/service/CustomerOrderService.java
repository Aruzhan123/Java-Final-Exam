package kz.aitu.testjava.service;

import kz.aitu.testjava.entity.Auth;
import kz.aitu.testjava.entity.CustomerOrder;
import kz.aitu.testjava.repository.AuthRepository;
import kz.aitu.testjava.repository.CustomerOrderRepository;
import kz.aitu.testjava.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerOrderService {
    private CustomerOrderRepository customerOrderRepository;
    private AuthRepository authRepository;
    private CustomerRepository customerRepository;



    public CustomerOrder insert(String token,CustomerOrder customerOrder) {
        Auth auth = authRepository.findByToken(token);
        customerOrder.setCustomerId(auth.getCustomerId());
        return customerOrderRepository.save(customerOrder);

    }

    public int customerOrder(){
        return customerOrderRepository.lastCustomerOrder();
    }

    public List<CustomerOrder> getByCustomerId(Long customerId) {
        return customerOrderRepository.findAllByCustomerId(customerId);
    }


    public List<Order> getByStatusId(Long statusId) {
        return customerOrderRepository.findAllByStatusId(statusId);
    }


}
