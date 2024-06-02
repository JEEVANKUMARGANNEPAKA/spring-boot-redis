package com.jeevankumar.spring_boot_redis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash(value = "Product")
public class Product implements Serializable {
    @Id
    private Integer id;
    private String productName;
    private Integer ProductQty;
    private BigDecimal productPrice;

}
