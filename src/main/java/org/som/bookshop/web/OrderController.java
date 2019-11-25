package org.som.bookshop.web;

import org.som.bookshop.entity.CartVo;
import org.som.bookshop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author : soulmate
 * @date : 2019/11/25  14:46
 * @description :
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private CartService cartService;

    /**
     * 提交订单
     */
    @RequestMapping("/confirm")
    public String confirm(String ids , Model model){
        //查询记录
        List<CartVo> cartVos = cartService.findCartByIds(ids);
        model.addAttribute("list",cartVos);
        return "confirm_order";
    }

}
