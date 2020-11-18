package kz.aitu.testjava.service;

import kz.aitu.testjava.entity.Auth;
import kz.aitu.testjava.entity.Customer;
import kz.aitu.testjava.repository.AuthRepository;
import kz.aitu.testjava.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;


@Service
@AllArgsConstructor
public class AuthService {

    private AuthRepository authRepository;
    private CustomerRepository customerRepository;





    @Transactional
    public Auth login(Auth auth) throws Exception {

        Auth authDB = authRepository.findByLoginAndPassword(auth.getLogin(), auth.getPassword());

        if(authDB == null) {
            throw new Exception();
        }

        String token = UUID.randomUUID().toString();

        authDB.setToken(token);
        return authRepository.save(authDB);
    }

    public Customer getCustomerByToken(String token) throws Exception {
        Auth authDB = authRepository.findByToken(token);
        return customerRepository.findById(authDB.getCustomerId()).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }



}
