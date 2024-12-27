package com.onlineshop.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EntityScan(basePackages = {"com.onlineshop.app.Entities"})
@EnableJpaRepositories("com.onlineshop.app.Repositories")
@SpringBootApplication
public class OnlineShopBeApplication {
	public static void main(String[] args) {
		SpringApplication.run(OnlineShopBeApplication.class, args);
	}

}
