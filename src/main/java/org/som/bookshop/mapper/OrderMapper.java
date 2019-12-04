package org.som.bookshop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.som.bookshop.entity.Order;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : soulmate
 * @date : 2019/12/3  15:43
 * @description :
 */
@Repository
public interface OrderMapper extends BaseMapper<Order> {
    /**
     * 根据用户id查询用户订单以及订单明细
     */
    List<Order> findOrderAndOrderDetailListByUser(Integer id);
}
