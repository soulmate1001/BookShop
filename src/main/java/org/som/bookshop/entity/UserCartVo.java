package org.som.bookshop.entity;

import lombok.Data;

/**
 * @author soulmate
 * @date 2019/11/22  11:46
 * @description:用户购物车信息VO类
 */
@Data
public class UserCartVo {
    private Integer num;
    private double totalPrice;
}
