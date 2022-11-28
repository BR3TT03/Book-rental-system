package com.example.bookrentalsystem.mapper;

import com.example.bookrentalsystem.pojo.book.BookDetailIdNameResponsePojo;
import com.example.bookrentalsystem.pojo.book.BookDetailsPojo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface BookDetailMapper {
    @Select("select tb.book_id as bookId,tb.book_name as bookName,tb.photo as photo,tb.isbn as isbn,tb.no_of_pages\n" +
            "as noOfPages,tb.published_date as publishedDate,tb.rating as rating,tb.stock_count as stockCount,\n" +
            "tc.category_id as categoryId,tc.category_name as categoryName,ta.author_id as authorId,ta.author_name\n" +
            "as authorName from tbl_book tb inner join tbl_category tc on tb.category_id=tc.category_id inner join\n" +
            "tbl_book_author tba on tb.book_id = tba.book_book_id inner join tbl_author ta on tba.author_author_id\n" +
            "= ta.author_id where tb.book_id=#{bookId}")
    Optional<BookDetailsPojo> getBookById(Integer bookId);


    @Select("select book_name from tbl_book where \"book_id\"=#{bookId}")
    String getBookName(Integer bookId);


    @Select("select stock_count from tbl_book where \"book_id\"=#{bookId}")
    Integer getBookCount(Integer bookId);

    @Select("select book_id as bookId, book_name as bookName from tbl_book")
    List<BookDetailIdNameResponsePojo> getBookIdName();

    @Select("select tb.book_id as bookId,tb.book_name as bookName,tb.photo as photo,tb.isbn as isbn,tb.no_of_pages\n" +
            "as noOfPages,tb.published_date as publishedDate,tb.rating as rating,tb.stock_count as stockCount,\n" +
            "tc.category_id as categoryId,tc.category_name as categoryName,ta.author_id as authorId,ta.author_name\n" +
            "as authorName from tbl_book tb inner join tbl_category tc on tb.category_id=tc.category_id inner join\n" +
            "tbl_book_author tba on tb.book_id = tba.book_book_id inner join tbl_author ta on tba.author_author_id\n" +
            "= ta.author_id order by tb.book_id")
    List<BookDetailsPojo> getAllBook();
}
