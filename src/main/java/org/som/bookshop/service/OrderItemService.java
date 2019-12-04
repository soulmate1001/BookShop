package org.som.bookshop.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.som.bookshop.entity.OrderItem;
import org.som.bookshop.mapper.OrderItemMapper;
import org.springframework.stereotype.Service;

/**
 * @author : soulmate
 * @date : 2019/12/3  15:48
 * @description :
 */
@Service
public class OrderItemService extends ServiceImpl<OrderItemMapper, OrderItem> {
}
