package com.example.bookrentalsystem.controller;

import com.example.bookrentalsystem.globalException.CustomExceptionHandler;
import com.example.bookrentalsystem.model.BookTransaction;
import com.example.bookrentalsystem.pojo.ApiResponse;
import com.example.bookrentalsystem.pojo.BookTransactionDetailRequestPojo;
import com.example.bookrentalsystem.service.booktransaction.BookTransactionService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("bookrent/booktransaction")
public class BookTransactionController extends ApiResponse {
    private final BookTransactionService bookTransactionService;

    public BookTransactionController(BookTransactionService bookTransactionService) {
        this.bookTransactionService = bookTransactionService;
    }


    @GetMapping()
    public ApiResponse getBookTransaction() {
        return success(get("data.get","Book Transaction"), bookTransactionService.getBookTransaction());
    }

    @PostMapping()
    public ApiResponse saveBookTransactionDetails(@RequestBody @Valid BookTransactionDetailRequestPojo bookTransactionDetailRequestPojo) throws CustomExceptionHandler {
        bookTransactionService.saveBookTransactionDetails(bookTransactionDetailRequestPojo);
        return success(get("data.save","Book Transaction"), null);
    }

    @PostMapping("rentabook")
    public ApiResponse rentBookTransaction(@RequestBody @Valid BookTransactionDetailRequestPojo bookTransactionDetailRequestPojo) throws CustomExceptionHandler {
        bookTransactionService.addNewTransaction(bookTransactionDetailRequestPojo);
        return success(get("book.rent"), null);
    }
    @PostMapping("returnabook")
    public ApiResponse returnABookTransaction(@RequestBody @Valid BookTransactionDetailRequestPojo bookTransactionDetailRequestPojo){
        bookTransactionService.addReturnTransaction(bookTransactionDetailRequestPojo);
        return success(get("book.return"),null);
    }

    @GetMapping("/{memberid}")
    public ApiResponse getBookTransactionByMemberId(@PathVariable(name = "memberid") Integer memberId) {
        return success(get("data.get","Book Transaction"), bookTransactionService.getBookTransactionById(memberId));
    }
}
