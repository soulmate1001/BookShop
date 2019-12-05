package org.som.bookshop;

import org.junit.jupiter.api.Test;
import org.som.bookshop.mapper.CartMapper;
import org.som.bookshop.mapper.OrderMapper;
import org.som.bookshop.orderUtils.OrderUtil;
import org.som.bookshop.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class BookShopApplicationTests {
	@Autowired
	private BookService bookService;
	@Autowired
	private CartMapper cartMapper;
	@Autowired
	private OrderMapper orderMapper;


	//测试图书查询
	@Test
	void findBookList() {
		bookService.list().forEach(System.out::println);
	}

	//测试购物车信息是否可以查询出来
	@Test
	public void findCartList(){
		cartMapper.findCartListByUserId(2).forEach(System.out::println);
	}

	//测试图书订单详情列表
	@Test
	public void findOrderList(){
		orderMapper.findOrderAndOrderDetailListByUser(2);
	}

	//测试订单编号生成器
	@Test
	public void createOrderNum(){

		System.out.println(OrderUtil.createOrderNum());
	}

}
