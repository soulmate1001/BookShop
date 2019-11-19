package org.som.bookshop.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import org.som.bookshop.entity.enums.Category;
import org.som.bookshop.entity.enums.Suit;

import java.util.Date;

/**
 * @outhor soulmate
 * @create 2019/10/31-17:32
 */
@Data
@TableName(value = "bs_book")
public class Book extends Model<Book> {

    @TableId(type = IdType.AUTO)   //设置ID这个字段为自增
    private Integer id;     //书的id
    private String isbn;   //isbn号是国际标准书号的简称
    private String name;   //书名
    private String author;   //书籍作者
    private String publisher; //书籍出版社
    private Date publishDate;  //出版日期,因为数据库字段名是publish_date,所以这里使用驼峰命名规则
    private double oldPrice;   //旧价格
    private double newPrice;   //新价格
    private String authorLoc;  //作者国籍
    private Suit suit;   //书本是否套装
    private Category category; //书本的类别
    private String info;   //图书基本信息介绍
    private String imgUrl;   //图书展示图片

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public double getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(double oldPrice) {
        this.oldPrice = oldPrice;
    }

    public double getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(double newPrice) {
        this.newPrice = newPrice;
    }

    public String getAuthorLoc() {
        return authorLoc;
    }

    public void setAuthorLoc(String authorLoc) {
        this.authorLoc = authorLoc;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
