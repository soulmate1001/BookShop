package org.som.bookshop.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 * @author soulmate
 * @date 2019/11/21  14:14
 * @description
 */
@Data
public class CartVo extends Model<CartVo> {
    private Integer id;
    private Integer userId;
    private Integer bookId;
    private Integer count;
    private String bookName;
    private String imgUrl;
    private double newPrice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public double getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(double newPrice) {
        this.newPrice = newPrice;
    }
}
