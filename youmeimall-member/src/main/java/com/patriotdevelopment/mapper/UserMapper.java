package com.patriotdevelopment.mapper;

import com.patriotdevelopment.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    public  int register(User user);

    public User login(User user);

    public User getUserByUsername(@Param("username") String username);
}
