package org.som.bookshop;

import org.junit.jupiter.api.Test;
import org.som.bookshop.mapper.CartMapper;
import org.som.bookshop.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookShopApplicationTests {
	@Autowired
	private BookService bookService;
	@Autowired
	private CartMapper cartMapper;


	@Test
	void findBookList() {
		bookService.list().forEach(System.out::println);
	}

	//测试购物车信息是否可以查询出来
	@Test
	public void findCartList(){
		cartMapper.findCartListByUserId(2).forEach(System.out::println);
	}

}
