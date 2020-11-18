package kz.aitu.testjava.controller;

import kz.aitu.testjava.entity.OrderItem;
import kz.aitu.testjava.service.OrderItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class OrderItemController {
    private OrderItemService orderItemService;

    @PostMapping("/api/orderitems")
    public ResponseEntity<?> createOrder_item(@RequestBody OrderItem orderItem) {
        return ResponseEntity.ok(orderItemService.save(orderItem));
    }
}
