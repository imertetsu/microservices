package com.serviceproduct.product;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(
		properties = {"spring.cloud.sleuth.enabled=false"}
)
class ProductApplicationTests {

	@Test
	void contextLoads() {
	}

}
