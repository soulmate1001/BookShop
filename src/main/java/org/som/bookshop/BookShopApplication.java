package org.som.bookshop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.som.bookshop.mapper")
public class BookShopApplication {

	//启动类
	public static void main(String[] args) {
		SpringApplication.run(BookShopApplication.class, args);
	}

}
