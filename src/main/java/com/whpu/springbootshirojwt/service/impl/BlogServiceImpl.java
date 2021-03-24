package com.whpu.springbootshirojwt.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.whpu.springbootshirojwt.entity.Blog;
import com.whpu.springbootshirojwt.mapper.BlogMapper;
import com.whpu.springbootshirojwt.service.BlogService;
import org.springframework.stereotype.Service;

@Service
public class  BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

}
