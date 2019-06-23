package com.example.ssmspringboot.dao;



import com.example.ssmspringboot.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Mapper
@Repository("userMapper")
public interface UserMapper {

    @Select("  SELECT * FROM user WHERE username = #{username}")
    User findByUsername(String username);

    @Select(" SELECT * FROM user")
    ArrayList<User> findAll();

    @Select("select * from user where id=#{id}")
    User findById(Integer id);
    @Update("update user set username = #{username}, password = #{password}, role=#{role}  where id = #{id}")
    void update(User user);

    @Delete("delete from user where  id=#{id,jdbcType=INTEGER}")
    String delete(User user);

    @Insert("insert into user(username, password, role) values (#{username},#{password},#{role})")
    String insert(User user);

}


