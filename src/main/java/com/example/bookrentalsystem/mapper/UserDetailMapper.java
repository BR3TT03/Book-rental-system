package com.example.bookrentalsystem.mapper;

import com.example.bookrentalsystem.model.User;
import com.example.bookrentalsystem.pojo.user.UserDetailResponsePojo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserDetailMapper {

    @Select("select user_id, user_name as \"userName\" from users u where \"user_name\" = #{userName}")
    User getUserDetailByUserName(String UserName);

    Optional<UserDetailResponsePojo> findById(Integer id);
    @Select("select user_id as userId,password as password,user_name as userName,user_type as userType from users where \"user_id\"=#{id}")
    Optional<UserDetailResponsePojo> findUserById(Integer id);
    @Select("select user_id as userId,password as password,user_name as userName,user_type as userType from users where \"user_name\"=#{userName}")
    UserDetailResponsePojo findUserByUserName(String userName);
    @Select("select user_id as userId,password as password,user_name as userName,user_type as userType from users order by user_id")
    List<UserDetailResponsePojo> getAllUser();
}