package org.som.bookshop.orderUtils;

import org.omg.CORBA.StringHolder;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author : soulmate
 * @date : 2019/12/5  16:10
 * @description : 订单编号生成器
 */
public class OrderUtil {
    private static long orderNum = 01;
    private static String date;

    /**
     * 生成订单编号
     */
    public static synchronized String createOrderNum(){
        String str = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        if(date == null || !date.equals(str)){
            date = str;
            orderNum = 01;
        }
        orderNum ++;
        long orderNo = Long.parseLong(date) * 10000;
        orderNo += orderNum;
        return String.valueOf(orderNo);
    }
}
