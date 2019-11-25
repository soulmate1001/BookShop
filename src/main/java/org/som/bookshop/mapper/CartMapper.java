package org.som.bookshop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.som.bookshop.entity.Cart;
import org.som.bookshop.entity.CartVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author soulmate
 * @date 2019/11/15  10:55
 * @description
 */

@Repository
public interface CartMapper extends BaseMapper<Cart> {
    //根据用户ID查找书记购物车信息
    @Select("SELECT\n" +
            "\tbsc.*, bsb.img_url AS imgUrl,\n" +
            "\tbsb.`name` AS bookName,\n" +
            "\tbsb.new_price AS newPrice\n" +
            "FROM\n" +
            "\tbs_cart bsc\n" +
            "LEFT JOIN bs_book bsb ON bsc.book_id = bsb.id\n" +
            "WHERE\n" +
            "\tbsc.user_id = #{userId}")
    List<CartVo> findCartListByUserId(Integer userId);
    //根据用户ID查找书记购物车信息
    @Select({
            "<script>" +
                "SELECT\n" +
                "\tbsc.*, bsb.img_url AS imgUrl,\n" +
                "\tbsb.`name` AS bookName,\n" +
                "\tbsb.new_price AS newPrice\n" +
                "FROM\n" +
                "\tbs_cart bsc\n" +
                "LEFT JOIN bs_book bsb ON bsc.book_id = bsb.id\n" +
                "WHERE bsc.id in \n" +
                "<foreach item='item' collection='ids' open='(' separator=',' close=')'>" +
                    "#{item}" +
                "</foreach>" +
            "</script>"
            })
    List<CartVo> findCartListByIds(@Param("ids") List<String> ids);

}
