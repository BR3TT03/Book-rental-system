package com.example.bookrentalsystem.mapper;

import com.example.bookrentalsystem.pojo.author.AuthorDetailResponsePojo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AuthorDetailMapper {
    @Select("select author_id as authorId,author_email as authorEmail,author_phone_no as authorMobile,author_name as authorName from tbl_author where \"author_id\"= #{authorId}")
    AuthorDetailResponsePojo getAuthorById(Integer authorId);

    @Select("select author_id as authorId,author_email as authorEmail,author_phone_no as authorMobile,author_name as authorName  from tbl_author order by author_id ")
    List<AuthorDetailResponsePojo> getAllAuthor();
}
