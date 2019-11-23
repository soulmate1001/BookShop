package org.som.bookshop.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.som.bookshop.entity.Cart;
import org.som.bookshop.entity.CartVo;
import org.som.bookshop.mapper.CartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author soulmate
 * @date 2019/11/15  10:56
 * @description
 */
@Service
public class CartService extends ServiceImpl<CartMapper, Cart> {
    @Autowired
    private CartMapper cartMapper;

    public List<CartVo> findCartByUser(Integer userId){
        return cartMapper.findCartListByUserId(userId);
    }

    /**
     * 购物车的
     */
    public double getCartItemTotal(List<CartVo> list){
        double sum = 0.0;
        for (CartVo cart:list) {
            sum += cart.getCount()*cart.getNewPrice();
        }
        return sum;
    }
}
