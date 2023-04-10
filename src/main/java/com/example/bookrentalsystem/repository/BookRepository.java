package com.example.bookrentalsystem.repository;

import com.example.bookrentalsystem.model.Book;
import com.example.bookrentalsystem.pojo.book.BookDetailsPojo;
import com.example.bookrentalsystem.pojo.book.BookDetailsResponsePojo;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book,Integer>  {
    @Modifying
    @Query(value = "update  tbl_book set stock_count =stock_count-1 where \"book_id\"=?1",nativeQuery = true)
    void updateBookRent(Integer bookId);
    @Modifying
    @Query(value = "update  tbl_book set stock_count =stock_count+1 where \"book_id\"=?1",nativeQuery = true)
    void updateBookReturn(Integer bookId);

    @Modifying
    @Query(value = "update  tbl_book set stock_count =stock_count + ?2  where \"book_id\"=?1",nativeQuery = true)
    void updateBookStock(Integer bookId, Integer stockCount);

//    @Modifying
//    @Query(value = "update  tbl_book set stock_count =stock_count+1 where \"book_id\"=?1",nativeQuery = true)
//    void updateBookReturn(Integer bookId);

    @Query(value = "select new com.example.bookrentalsystem.pojo.book.BookDetailsPojo( tb.book_id as bookId,tb.book_name as bookName,tb.photo as photo,tb.isbn as isbn,tb.no_of_pages\n" +
            "as noOfPages,tb.published_date as publishedDate,tb.rating as rating,tb.stock_count as stockCount,\n" +
            "tc.category_id as categoryId,tc.category_name as categoryName,ta.author_id as authorId,ta.author_name\n" +
            "as authorName from tbl_book tb inner join tbl_category tc on tb.category_id=tc.category_id inner join\n" +
            "tbl_book_author tba on tb.book_id = tba.book_book_id inner join tbl_author ta on tba.author_author_id\n" +
            "= ta.author_id order by tb.book_id)",nativeQuery = true)
    Page<BookDetailsPojo> getAllBookPage(Pageable pageable);

    @Query(value = "select new com.example.bookrentalsystem.pojo.book.BookDetailsResponsePojo( tb.book_id as bookId,tb.book_name as bookName,tb.photo as photo,tb.isbn as isbn,tb.no_of_pages\n" +
            "as noOfPages,tb.published_date as publishedDate,tb.rating as rating,tb.stock_count as stockCount,\n" +
            "tc.category_id as categoryId,tc.category_name as categoryName,ta.author_id as authorId,ta.author_name\n" +
            "as authorName from tbl_book tb inner join tbl_category tc on tb.category_id=tc.category_id inner join\n" +
            "tbl_book_author tba on tb.book_id = tba.book_book_id inner join tbl_author ta on tba.author_author_id\n" +
            "= ta.author_id order by tb.book_id)",nativeQuery = true)
    List<BookDetailsResponsePojo> getAllBooks();
}
