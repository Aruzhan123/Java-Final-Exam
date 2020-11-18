package kz.aitu.testjava.service;

import kz.aitu.testjava.entity.Product;
import kz.aitu.testjava.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository = null;



    public List<Product> getAll() {

        return (List<Product>) productRepository.findAll();
    }

    public List<Product> getByCategoryId(Long categoryId)
    {
        return productRepository.findAllByCategoryId(categoryId);
    }

    public Product save(Product group) {
        return productRepository.save(group);
    }
}
