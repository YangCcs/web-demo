package com.yangcs.mapper;

import com.yangcs.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from tb_user where id = #{id}")
    User selectById(Integer id);

    @Select("select * from tb_user where phone=#{phone}")
    User selectByPhone(String phone);

    @Select("select * from tb_user")
    List<User> selectAll();

    @Insert("insert into tb_user(name, gender, age, phone) values(#{name}, #{gender}, #{age}, #{phone})")
    Boolean insert(String name, Boolean gender, String age, String phone); // 注意这个age的类型不对哦

    @Update("update tb_user set name=#{name}, gender=#{gender}, age=#{age}, phone=#{phone} where id=#{id}")
    Boolean update(Integer id, String name, Boolean gender, Integer age, String phone);

    @Delete("delete from tb_user where id=#{id}")
    Boolean delete(Integer id);
}
