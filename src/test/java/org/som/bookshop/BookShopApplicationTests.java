package org.som.bookshop;

import org.junit.jupiter.api.Test;
import org.som.bookshop.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookShopApplicationTests {
	@Autowired
	private BookService bookService;


	@Test
	void findBookList() {
		bookService.list().forEach(System.out::println);
	}

}
