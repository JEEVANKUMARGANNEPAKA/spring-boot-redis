package com.jeevankumar.spring_boot_redis;

import com.jeevankumar.spring_boot_redis.entity.Product;
import com.jeevankumar.spring_boot_redis.repository.ProductDao;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class SpringBootRedisApplication {

	private  final ProductDao dao;

	@PostMapping
	public Product save(@RequestBody Product product) {
		return dao.saveProduct(product);
	}

//	@GetMapping
//	public List<Object> getAllProducts() {
//		return dao.findAllProducts();
//	}

	@GetMapping("/{id}")
	public Product findProduct(@PathVariable Integer id) {
		return dao.findProductById(id);
	}
	@DeleteMapping("/{id}")
	public String remove(@PathVariable Integer id)   {
		return dao.deleteProduct(id);
	}


	public static void main(String[] args) {
		SpringApplication.run(SpringBootRedisApplication.class, args);
	}

}
