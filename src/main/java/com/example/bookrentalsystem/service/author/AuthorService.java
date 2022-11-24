package com.example.bookrentalsystem.service.author;

import com.example.bookrentalsystem.globalException.AppException;
import com.example.bookrentalsystem.model.Author;
import com.example.bookrentalsystem.pojo.author.AuthorDetailRequestPojo;
import com.example.bookrentalsystem.pojo.author.AuthorDetailResponsePojo;

import java.util.List;

public interface AuthorService {
    AuthorDetailResponsePojo getAuthorById(Integer authorId) throws AppException;
    void saveAuthorDetails(AuthorDetailRequestPojo authorDetailRequestPojo);
     List<AuthorDetailResponsePojo> getAuthor();

     void  deleteAuthorById(Integer authorId) throws AppException;
}
