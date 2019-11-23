package org.som.bookshop.entity;

import lombok.Data;

/**
 * @author soulmate
 * @date 2019/11/22  11:46
 * @description:用户购物车信息VO类
 */
@Data
public class UserCartVo {

    //商品的数量
    private Integer num;
    //商品的总价
    private double totalPrice;

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
