package org.som.bookshop.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.som.bookshop.entity.Book;
import org.som.bookshop.mapper.BookMapper;
import org.springframework.stereotype.Service;

/**
 * @outhor soulmate
 * @create 2019/10/31-22:06
 * @Description:图书业务层
 */
@Service
public class BookService extends ServiceImpl<BookMapper,Book> {

}
