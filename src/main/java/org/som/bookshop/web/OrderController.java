package org.som.bookshop.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.som.bookshop.entity.Address;
import org.som.bookshop.entity.CartVo;
import org.som.bookshop.entity.User;
import org.som.bookshop.service.AddressService;
import org.som.bookshop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
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

    @Autowired
    private AddressService  addressService;

    /**
     * 提交订单
     */
    @RequestMapping("/confirm")
    public String confirm(String ids , HttpSession session, Model model){
        //查询记录
        List<CartVo> cartVos = cartService.findCartByIds(ids);

        //获取当前用户的地址
        QueryWrapper<Address> addressQueryWrapper = new QueryWrapper<>();
        User user = (User)session.getAttribute("user");
        addressQueryWrapper.eq("user_id",user.getId());
        List<Address> addressList = addressService.list(addressQueryWrapper);

        model.addAttribute("list",cartVos);
        model.addAttribute("addressList",addressList);
        return "confirm_order";
    }

}
