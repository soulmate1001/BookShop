package org.som.bookshop.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.som.bookshop.entity.CartVo;
import org.som.bookshop.entity.Order;
import org.som.bookshop.entity.OrderItem;
import org.som.bookshop.entity.User;
import org.som.bookshop.mapper.OrderMapper;
import org.som.bookshop.orderUtils.OrderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author : soulmate
 * @date : 2019/12/3  15:47
 * @description :购买操作
 */
@Service
public class OrderService extends ServiceImpl<OrderMapper, Order> {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderItemService orderItemService;
    @Autowired
    private CartService cartService;

    /**
     * 购买
     * @param cartVos
     * @param addrId
     * @param session
     * @return
     */
    public String buy(List<CartVo> cartVos, Integer addrId , HttpSession session) {
        //1.生成订单表记录
        Order order = new Order();
        User user = (User) session.getAttribute("user");

        order.setAddressId(addrId);
        order.setUserId(user.getId());
        order.setCreateDate(new Date());
//        order.setOrderNum(UUID.randomUUID().toString());
        order.setOrderNum(OrderUtil.createOrderNum());  //自定义生成订单编号
        order.setOrderStatus("1");
        orderMapper.insert(order);

        //2.生成订单明细表记录
        List<OrderItem> orderItems = new ArrayList<>();
        List<Integer> cartIds = new ArrayList<>();
        for (CartVo cart:cartVos) {
            OrderItem orderItem = new OrderItem();
            orderItem.setBookId(cart.getBookId());
            orderItem.setCount(cart.getCount());
            orderItem.setOrderId(order.getId());
            orderItems.add(orderItem);
            cartIds.add(cart.getId());
        }

        orderItemService.saveBatch(orderItems);
        //3.删除购物车表中记录
        cartService.removeByIds(cartIds);
        return "success";
    }

    /**
     * 查询用户详细订单
     */
    public List<Order> findUserOrder(Integer userId){
        List<Order> list = orderMapper.findOrderAndOrderDetailListByUser(userId);
        for (Order order:list) {
            List<OrderItem> orderItems = order.getOrderItems();
            double price = 0.0;
            for (OrderItem orderItem:orderItems) {
                price += orderItem.getCount() * orderItem.getBook().getNewPrice();
            }
            order.setTotalPrice(price);
        }
        
        return list;
    }
}
