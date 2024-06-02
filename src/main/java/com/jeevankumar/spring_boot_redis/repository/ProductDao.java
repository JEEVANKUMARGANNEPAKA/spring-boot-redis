package com.jeevankumar.spring_boot_redis.repository;

import com.jeevankumar.spring_boot_redis.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;


@Repository
@RequiredArgsConstructor
public class ProductDao {

    public static final String HASH_KEY = "Product";

    private  final RedisTemplate<String,Object> template;

    public Product saveProduct(Product product){
         template.opsForHash().put(HASH_KEY,product.getId(),product);
        return product;
    }
//    public List<Object> findAllProducts(){
//        List<Object> products = this.template.opsForHash().values(HASH_KEY);
//        return products;
//
//    }
    public Product findProductById(Integer id){
        return (Product) template.opsForHash().get(HASH_KEY,id);
    }


    public String deleteProduct(Integer id){
        template.opsForHash().delete(HASH_KEY,id);
        return "product removed !!";
    }
}
