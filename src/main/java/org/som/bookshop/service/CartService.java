package org.som.bookshop.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.som.bookshop.entity.Cart;
import org.som.bookshop.mapper.CartMapper;
import org.springframework.stereotype.Service;

/**
 * @author soulmate
 * @date 2019/11/15  10:56
 * @description
 */
@Service
public class CartService extends ServiceImpl<CartMapper, Cart> {
}
