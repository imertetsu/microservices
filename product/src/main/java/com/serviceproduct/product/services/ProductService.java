package com.serviceproduct.product.services;

import com.serviceproduct.product.entities.ProductEntity;
import com.serviceproduct.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductEntity> getAllProducts(){
        return this.productRepository.findAll();
    }

    public List<ProductEntity> getProductsByCategory(Long categoryId){

        return this.productRepository.findAllByCategoryId(categoryId);
    }

    public ProductEntity getProductById(Long id){
        return this.productRepository.findById(id).orElse(null);
    }

    public ProductEntity createProduct(ProductEntity product){
        return this.productRepository.save(product);
    }

    public ProductEntity updateProduct(ProductEntity product){
        ProductEntity productToUpdate = this.productRepository.findById(product.getId()).orElse(null);
        if(productToUpdate == null){
            return null;
        }else{
            return this.productRepository.save(productToUpdate);
        }

    }
}
