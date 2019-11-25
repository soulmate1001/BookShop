package org.som.bookshop.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.som.bookshop.entity.Cart;
import org.som.bookshop.entity.CartVo;
import org.som.bookshop.entity.UserCartVo;
import org.som.bookshop.mapper.CartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
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

    /**
     * 根据用户查询
     * @param userId
     * @return
     */
    public List<CartVo> findCartByUser(Integer userId){
        return cartMapper.findCartListByUserId(userId);
    }

    /**
     *根据购物车Id查询对应的记录
     */
    public List<CartVo> findCartByIds(String ids){
        return cartMapper.findCartListByIds(Arrays.asList(ids));
    }

    /**
     * 购物车的总金额
     */
    public double getCartItemTotal(List<CartVo> list){
        double sum = 0.0;
        for (CartVo cart:list) {
            sum += cart.getCount()*cart.getNewPrice();
        }
        return sum;
    }

    /**
     *购物车批量删除
     * @param ids
     * @return
     */
    public String batchDelete(String ids) {
        if(null != ids){
            String[] idArray = ids.split(",");
            cartMapper.deleteBatchIds(Arrays.asList(idArray));
        }
        return "success";
    }

    /**
     * 包装用户购物车数据
     */
    public UserCartVo wrapperCart(List<CartVo> list){
        UserCartVo userCartVo = new UserCartVo();
        userCartVo.setNum(list.size());
        userCartVo.setTotalPrice(getCartItemTotal(list));
        return userCartVo;
    }
}
