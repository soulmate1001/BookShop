package org.som.bookshop.web;

import org.som.bookshop.entity.User;
import org.som.bookshop.entity.Address;
import org.som.bookshop.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author : soulmate
 * @date : 2019/11/27  11:41
 * @description :
 */
@Controller
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    /**
     * 添加地址功能
     * @param address
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping("save")
    public String save(Address address , HttpSession session){
        User user = (User)session.getAttribute("user");
        address.setUserId(user.getId());
        addressService.save(address);
        return "success";
    }

    /**
     *
     */

}
