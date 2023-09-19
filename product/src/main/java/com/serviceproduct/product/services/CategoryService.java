package com.serviceproduct.product.services;

import com.serviceproduct.product.entities.CategoryEntity;
import com.serviceproduct.product.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryEntity> getAllCategories(){
        return this.categoryRepository.findAll();
    }
}
