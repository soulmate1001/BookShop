package org.som.bookshop.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.som.bookshop.entity.Address;
import org.som.bookshop.entity.CartVo;
import org.som.bookshop.entity.Order;
import org.som.bookshop.entity.User;
import org.som.bookshop.service.AddressService;
import org.som.bookshop.service.CartService;
import org.som.bookshop.service.OrderService;
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

    @Autowired
    private OrderService orderService;

    /**
     * 确认订单
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

        //把地址购物车信息放在session中
        session.setAttribute("cartVos",cartVos);

        model.addAttribute("list",cartVos);
        model.addAttribute("addressList",addressList);
        return "confirm_order";
    }

    /**
     * 提交订单
     */
    @RequestMapping("/commitOrder")
    public String commitOrder(Integer addrId,HttpSession session){
        List<CartVo> cartVos = (List<CartVo>) session.getAttribute("cartVos");
        String flag = orderService.buy(cartVos, addrId ,session);
        if(flag.equals("success")){
            return "redirect:/order/list";
        }else{
            return "redirect:/book/index";
        }
    }

    /**
     * 显示用户订单列表
     */
    @RequestMapping("list")
    public String list(HttpSession session,Model model){
        User user = (User)session.getAttribute("user");
        List<Order> orders = orderService.findUserOrder(user.getId());
        model.addAttribute("orders",orders);
        return "order_list";

    }



}
