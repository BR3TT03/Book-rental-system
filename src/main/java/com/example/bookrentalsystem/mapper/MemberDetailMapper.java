package com.example.bookrentalsystem.mapper;

import com.example.bookrentalsystem.pojo.member.MemberDetailResponsePojo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MemberDetailMapper {
    Object findMemberById(Integer memberId);

    @Select("select member_id as memberId,address as address,email as email,mobile_no as mobileNo,name as name from tbl_member where \"member_id\"=#{memberId}")
    Optional<MemberDetailResponsePojo> getMemberById(Integer memberId);

    @Select("select member_id as memberId,address as address,email as email,mobile_no as mobileNo,name as name from tbl_member")
    List<MemberDetailResponsePojo> getAllMember();
}
