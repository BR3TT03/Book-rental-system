package com.example.bookrentalsystem.service.book;

import com.example.bookrentalsystem.globalException.AppException;
import com.example.bookrentalsystem.model.Book;
import com.example.bookrentalsystem.pojo.book.BookDetailIdNameResponsePojo;
import com.example.bookrentalsystem.pojo.book.BookDetailRequestPojo;
import com.example.bookrentalsystem.pojo.book.BookDetailResponsePojo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



public interface BookService   {
    Object getBookById(Integer bookId);
    void saveBookDetails(BookDetailRequestPojo bookDetailRequestPojo) throws Exception;
     List<BookDetailResponsePojo> getBook();

    @Transactional
    void updateBookStock(BookDetailRequestPojo bookDetailRequestPojo);

    void deleteBookById(Integer bookId) throws AppException;

    List<BookDetailIdNameResponsePojo> getBookIdName();
}
