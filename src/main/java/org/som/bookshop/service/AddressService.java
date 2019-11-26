package org.som.bookshop.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.som.bookshop.entity.Address;
import org.som.bookshop.mapper.AddressMapper;
import org.springframework.stereotype.Service;

/**
 * @author : soulmate
 * @date : 2019/11/25  22:51
 * @description :
 */
@Service
public class AddressService extends ServiceImpl<AddressMapper, Address> {
}
