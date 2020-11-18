package kz.aitu.testjava.controller;

import kz.aitu.testjava.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class ProductController {

    private ProductService productService;


    @GetMapping("/api/products")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(productService.getAll());
    }


    @GetMapping("/api/products/category/{categoryID}")
    public ResponseEntity<?> getAllByCategory(@PathVariable("categoryID") Long categoryID) {
        return ResponseEntity.ok(productService.getByCategoryId(categoryID));
    }

}
