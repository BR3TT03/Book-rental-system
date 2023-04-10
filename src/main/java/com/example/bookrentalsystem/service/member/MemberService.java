package com.example.bookrentalsystem.service.member;

import com.example.bookrentalsystem.globalException.AppException;
import com.example.bookrentalsystem.model.Member;
import com.example.bookrentalsystem.pojo.member.MemberDetailRequestPojo;
import com.example.bookrentalsystem.pojo.member.MemberDetailResponsePojo;

import java.util.List;

public interface MemberService {
    MemberDetailResponsePojo getMemberById(Integer memberId) throws AppException;
    void saveMemberDetails(MemberDetailRequestPojo memberDetailRequestPojo);
     List<MemberDetailResponsePojo> getMember();
    void deleteMemberById(Integer memberId) throws AppException;
}
