package com.example.bookrentalsystem.service.user;

import com.example.bookrentalsystem.globalException.AppException;
import com.example.bookrentalsystem.model.User;
import com.example.bookrentalsystem.pojo.user.UserDetailRequestPojo;
import com.example.bookrentalsystem.pojo.user.UserDetailResponsePojo;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserDetailResponsePojo getUserByUserId(Integer userId);


    @Select("select user_name as \"username\",password as \"password\" from users  where user_name = #{userName}")
    UserDetailResponsePojo getUserByUserName(String userName);

     List<UserDetailResponsePojo> getUser();
    void saveUserDetails(UserDetailRequestPojo userDetailRequestPojo);
    Optional<UserDetailResponsePojo> findById(Integer id);

    void deleteUserById(Integer userId) throws AppException;

}