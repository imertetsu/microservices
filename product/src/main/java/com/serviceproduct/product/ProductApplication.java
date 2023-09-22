package com.serviceproduct.product;

import com.serviceproduct.product.entities.ProductEntity;
import com.serviceproduct.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;


@SpringBootApplication
public class ProductApplication implements CommandLineRunner {
	@Autowired
	private final ProductRepository productRepository;
	public ProductApplication(ProductRepository productRepository){
		this.productRepository = productRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);

		System.out.println("hello");
	}

	@Override
	public void run(String... args) throws Exception {
		List<ProductEntity> products = this.productRepository.findAll();

		for(ProductEntity product: products){
			System.out.println(product.toString());
		}
	}
}
