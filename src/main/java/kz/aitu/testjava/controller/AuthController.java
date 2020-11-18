package kz.aitu.testjava.controller;

import kz.aitu.testjava.entity.Auth;
import kz.aitu.testjava.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class AuthController {

    private AuthService authService;


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Auth auth) {
        try {
            return ResponseEntity.ok(authService.login(auth));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @GetMapping("/customers/me")
    public ResponseEntity<?> me(@RequestHeader("Auth") String token) throws Exception {
        return ResponseEntity.ok(authService.getCustomerByToken(token));
    }


}
