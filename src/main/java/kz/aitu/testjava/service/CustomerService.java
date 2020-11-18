package kz.aitu.testjava.service;

import kz.aitu.testjava.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;



@Service
@AllArgsConstructor
public class CustomerService {

    private CustomerRepository customerRepository;


}
