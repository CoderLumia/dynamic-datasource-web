package com.lumia.web.mapper;

import com.lumia.web.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    @Insert("insert into tb_user(user_name, password, email) values (#{username}, #{password}, #{email})")
    int save(User user);

    @Results({@Result(property = "username", column = "user_name")})
    @Select("select * from tb_user")
    List<User> findAll();
}
