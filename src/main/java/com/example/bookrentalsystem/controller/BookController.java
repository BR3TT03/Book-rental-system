package com.example.bookrentalsystem.controller;

import com.example.bookrentalsystem.globalException.AppException;
import com.example.bookrentalsystem.model.Book;
import com.example.bookrentalsystem.pojo.api.ApiResponse;
import com.example.bookrentalsystem.pojo.api.BaseController;
import com.example.bookrentalsystem.pojo.book.BookDetailRequestPojo;
import com.example.bookrentalsystem.pojo.book.BookDetailsPojo;
import com.example.bookrentalsystem.pojo.book.BookDetailsResponsePojo;
import com.example.bookrentalsystem.service.book.BookService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * This controller returns book details and save book details using for data.
 */


@RestController
@RequestMapping("bookrental/book")
public class BookController extends BaseController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping()
    public ApiResponse getBook() {
        return success(get("data.get","Book"),bookService.getBook());
    }


    /**
     * This function saves the book details
     * @param bookDetailRequestPojo
     * @return saveBookDetails
     */
    @PostMapping()
    public ApiResponse saveBookDetails(@ModelAttribute @Valid  BookDetailRequestPojo bookDetailRequestPojo) throws Exception {
        bookService.saveBookDetails(bookDetailRequestPojo);
        return success(get("data.save","Book"), null);
    }

    @GetMapping("/{bookid}")
    public ApiResponse getBookById(@PathVariable(name = "bookid") Integer bookId) throws AppException {
        return success(get("data.get","Book"), bookService.getBookById(bookId));
    }
    @PostMapping("update-stock")
    public ApiResponse updateBookStock(@RequestBody @Valid BookDetailRequestPojo bookDetailRequestPojo){
        bookService.updateBookStock(bookDetailRequestPojo);
        return success(get("data.update.stock","Book"), null);
    }

    @GetMapping("get-book-id-name")
    public ApiResponse getBookIdName(){
        return  success(get("data.get","Book"),bookService.getBookIdName());
            }

    @DeleteMapping("/{bookid}")
    public ApiResponse deleteBookById(@PathVariable(name = "bookid")Integer bookId) throws AppException {
        bookService.deleteBookById(bookId);
        return success(get("data.delete","Book"),null);
    }

    @RequestMapping(value = "/pagination-and-sorting/{pageNumber}/{pageSize}",method = RequestMethod.GET)
    public Page<Book> bookDetailsResponsePojoPage(@PathVariable Integer pageNumber, @PathVariable Integer pageSize){
        return bookService.getAllBookPage( pageNumber, pageSize);
    }

}

