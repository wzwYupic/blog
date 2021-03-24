package com.whpu.springbootshirojwt.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.whpu.springbootshirojwt.entity.User;
import com.whpu.springbootshirojwt.mapper.UserMapper;
import com.whpu.springbootshirojwt.service.UserService;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
