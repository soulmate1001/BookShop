package org.som.bookshop.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.QueryChainWrapper;
import org.som.bookshop.entity.Cart;
import org.som.bookshop.entity.CartVo;
import org.som.bookshop.entity.User;
import org.som.bookshop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author soulmate
 * @date 2019/11/14  21:49
 * @description 购物车控制器
 */
@Controller
@RequestMapping("/cart")
public class CartController {
    //装配service
    @Autowired
    private CartService cartService;

    //添加购物车操作
    @ResponseBody
    @RequestMapping("/add")
    public String add(Cart cart, HttpSession session){
        //获取用户信息,提取用户的id
        User user = (User)session.getAttribute("user");
        cart.setUserId(user.getId());
        //判断购物车是否有用户和图书对应的信息
        QueryWrapper<Cart> cartQueryWrapper =  new QueryWrapper<>();
        cartQueryWrapper.eq("user_id",user.getId());
        cartQueryWrapper.eq("book_id",cart.getBookId());
        Cart queryCart = cartService.getOne(cartQueryWrapper);
        if(queryCart == null){
            cartService.save(cart);
        }else{
            queryCart.setCount(queryCart.getCount() + cart.getCount());
            cartService.updateById(queryCart);
        }
        return "success";
    }

    /**
     * 查询当前用户的购物车信息
     */
    @RequestMapping("/list")
    public String list(HttpSession session, Model model){
        //获取用户信息,提取用户的id
        User user = (User)session.getAttribute("user");
        if(null != user ){
            List<CartVo> cartVos = cartService.findCartByUser(user.getId());
            model.addAttribute("cartList",cartVos);
            return "cart";
        }
        return "index";

    }
}
