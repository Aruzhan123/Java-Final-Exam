package kz.aitu.testjava.service;

import kz.aitu.testjava.entity.Category;
import kz.aitu.testjava.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class CategoryService {

    private CategoryRepository categoryRepository;



    public List<Category> getAll() {
        return (List<Category>) categoryRepository.findAll();
    }

    public Category save(Category group) {
        return categoryRepository.save(group);
    }
}
