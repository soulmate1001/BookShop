package org.som.bookshop.entity.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * @outhor soulmate
 * @create 2019/10/31-17:56
 * @Description:图书套装枚举
 */
@Getter
public enum Suit {
    YES(1,"是"),NO(2,"不是");

    /**
     *
     * @param code  数据库代码
     * @param desc  描述
     */
    Suit(int code,String desc){
        this.code = code;
        this.desc = desc;
    }

    @EnumValue   //标记数据库存的值是code
    private final int code;
    private final String desc;
}
