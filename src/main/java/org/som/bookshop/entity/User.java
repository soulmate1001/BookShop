package org.som.bookshop.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 * @outhor soulmate
 * @create 2019/11/7-11:27
 * @Description:
 */
@Data
@TableName(value = "bs_user")
public class User{
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String company;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
