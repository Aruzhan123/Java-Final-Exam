package kz.aitu.testjava.repository;

import kz.aitu.testjava.entity.Auth;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends CrudRepository<Auth, Long> {


    Auth findByLoginAndPassword(String login, String password);

    Auth findByToken(String token);

}
