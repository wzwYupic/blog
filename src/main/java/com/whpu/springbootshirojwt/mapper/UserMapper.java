package com.whpu.springbootshirojwt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.whpu.springbootshirojwt.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}
