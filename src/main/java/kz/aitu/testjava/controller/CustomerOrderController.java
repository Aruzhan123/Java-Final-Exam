package kz.aitu.testjava.controller;

import kz.aitu.testjava.entity.CustomerOrder;
import kz.aitu.testjava.service.CustomerOrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class CustomerOrderController {
    private CustomerOrderService customerOrderService;
    private Long statusID;

    @PostMapping("/api/customerorders")
    public ResponseEntity<?> me(@RequestHeader("Token") String token, @RequestBody CustomerOrder customerOrder) throws Exception {
        return ResponseEntity.ok(customerOrderService.insert(token,customerOrder));
    }

    @GetMapping("/api/customerorders/me")
    public ResponseEntity<?> customerOrderId() {
        return ResponseEntity.ok(customerOrderService.customerOrder());
    }
    @GetMapping("/api/customer_orders/customers/{id}")
    public ResponseEntity<?> getByCustomersId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(customerOrderService.getByCustomerId(id));
    }

    @GetMapping("/order/status/{statusId}")
    public ResponseEntity<?> getAllByStatusId(@PathVariable("statusId") Long statusId) {
        return ResponseEntity.ok(customerOrderService.getByStatusId(statusID));
    }
}
