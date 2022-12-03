package com.example.bookrentalsystem.repository;

import com.example.bookrentalsystem.model.Author;
import com.example.bookrentalsystem.pojo.author.AuthorDetailResponsePojo;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface AuthorRepository extends JpaRepository<Author,Integer> {
    List<Author> findAll();

    @Query(value ="select * from (select author_id as authorId,author_email as authorEmail,\n" +
            "            author_phone_no as authorMobile,author_name as authorName\n" +
            "             from tbl_author tba order by author_id) tba",nativeQuery = true,countQuery = "select count(*) from (select author_id as authorId,author_email as authorEmail,\n" +
            "            author_phone_no as authorMobile,author_name as authorName\n" +
            "             from tbl_author tba order by author_id) tba")
    Page<Map<String,Object>> findAllAuthor(Pageable pageable);
}
