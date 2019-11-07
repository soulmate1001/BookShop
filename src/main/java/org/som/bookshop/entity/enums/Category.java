package org.som.bookshop.entity.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * @outhor soulmate
 * @create 2019/10/31-17:44
 * @Description:图书类型枚举类
 */
@Getter
public enum Category {
    SELECTED(1,"精选图书"),RECOMMEND(2,"推荐图书"),BARGAIN(3,"特价图书");

    /**
     *
     * @param code  数据库代码
     * @param desc  描述
     */
    Category(int code,String desc){
        this.code = code;
        this.desc = desc;
    }

    @EnumValue   //标记数据库存的值是code
    private final int code;
    private final String desc;
}
