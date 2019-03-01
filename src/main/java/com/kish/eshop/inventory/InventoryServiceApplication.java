package com.kish.eshop.inventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@SpringBootApplication
@EnableEurekaClient
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args); 
	}
	
	@Bean
	public JedisPool jedis() {
	    JedisPoolConfig config = new JedisPoolConfig();
	    config.setMaxTotal(100);
	    config.setMaxIdle(5);
	    config.setMaxWaitMillis(1000*10);
	    config.setTestOnBorrow(true);
	    return new JedisPool(config, "192.168.1.40", 1111);
	}
}