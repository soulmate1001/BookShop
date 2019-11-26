package org.som.bookshop.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author : soulmate
 * @date : 2019/11/25  20:39
 * @description :
 */
@Data
@TableName(value = "bs_address")
public class Address {
    private Integer id;
    private Integer userId;
    private String province;
    private String city;
    private String area;
    private String detailAddress;
    private String emailCode;
    private String receiver;
    private String tel;
    private String isDefault;

}
