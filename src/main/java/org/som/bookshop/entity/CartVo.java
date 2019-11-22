package org.som.bookshop.entity;

import lombok.Data;

/**
 * @author soulmate
 * @date 2019/11/21  14:14
 * @description
 */
@Data
public class CartVo {
    private Integer id;
    private Integer userId;
    private Integer bookId;
    private Integer count;
    private String bookName;
    private String imgUrl;
    private double newPrice;
}
