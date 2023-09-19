package com.serviceproduct.product;

import com.serviceproduct.product.entities.CategoryEntity;
import com.serviceproduct.product.entities.ProductEntity;
import com.serviceproduct.product.repository.ProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.List;

@DataJpaTest
public class ProductRepositoryMockTest {
    @Autowired
    private final ProductRepository productRepository;

    public ProductRepositoryMockTest(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Test
    public void whenFindAllProducts_thenReturnListProducts(){
        ProductEntity product01 = ProductEntity.builder()
                .name("Love and Hate")
                .category(CategoryEntity.builder().id(2L).build())
                .description("")
                .stock(Double.parseDouble("5"))
                .price(Double.parseDouble("55.5"))
                .status("Created")
                .createdAt(new Date()).build();
        this.productRepository.save(product01);

        List<ProductEntity> products = productRepository.findAll();
        System.out.println(products.get(products.size()-1).toString());
        Assertions.assertThat(products.size()).isEqualTo(4);
    }
}
