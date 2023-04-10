package com.example.bookrentalsystem.pojo.book;

import lombok.AllArgsConstructor;
import lombok.Getter;

import lombok.Setter;


import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class BookDetailsPojo {
    private Integer bookId;

    private String bookName;

    private String photo;

    private String isbn;

    private Integer noOfPages;

    private Date publishedDate;


    private Double rating;


    private Integer stockCount;

    private Integer categoryId;

    private String categoryName;

    private Integer authorId;

    private String authorName;
}
