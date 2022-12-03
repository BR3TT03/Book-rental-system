package com.example.bookrentalsystem.service.book;

import com.example.bookrentalsystem.globalException.AppException;
import com.example.bookrentalsystem.model.Book;
import com.example.bookrentalsystem.pojo.book.BookDetailIdNameResponsePojo;
import com.example.bookrentalsystem.pojo.book.BookDetailRequestPojo;
import com.example.bookrentalsystem.pojo.book.BookDetailsPojo;
import com.example.bookrentalsystem.pojo.book.BookDetailsResponsePojo;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



public interface BookService {
    BookDetailsPojo getBookById(Integer bookId) throws AppException;
    void saveBookDetails(BookDetailRequestPojo bookDetailRequestPojo) throws Exception;
     List<BookDetailsResponsePojo> getBook();

    @Transactional
    void updateBookStock(BookDetailRequestPojo bookDetailRequestPojo);

    void deleteBookById(Integer bookId) throws AppException;

    List<BookDetailIdNameResponsePojo> getBookIdName();

    Page<Book> getAllBookPage(Integer pageNumber, Integer pageSize);
}
