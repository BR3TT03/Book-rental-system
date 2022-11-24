package com.example.bookrentalsystem.service.booktransaction;


import com.example.bookrentalsystem.globalException.AppException;
import com.example.bookrentalsystem.model.BookTransaction;
import com.example.bookrentalsystem.pojo.bookTransaction.BookTransactionDetailRequestPojo;
import com.example.bookrentalsystem.pojo.bookTransaction.BookTransactionDetailResponsePojo;

import java.util.List;

public interface BookTransactionService {
    BookTransactionDetailResponsePojo getBookTransactionById(Integer bookTransactionId) throws AppException;
     List<BookTransactionDetailResponsePojo> getBookTransaction();

    void addNewTransaction(BookTransactionDetailRequestPojo bookTransactionDetailRequestPojo) throws AppException;

    List<BookTransactionDetailResponsePojo> getBookTransactionByMemberId(Integer memberId) throws AppException;

    void addReturnTransaction(BookTransactionDetailRequestPojo bookTransactionDetailRequestPojo);

//    void addNewReturnTransaction(BookTransactionDetailRequestPojo bookTransactionDetailRequestPojo);

//    void returnBookTransaction(BookTransactionDetailRequestPojo bookTransactionDetailRequestPojo);

    void deleteBookTransactionById(Integer bookTransactionId) throws AppException;
}
