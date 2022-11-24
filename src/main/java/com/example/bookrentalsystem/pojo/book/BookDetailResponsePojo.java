package com.example.bookrentalsystem.pojo.book;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Service
public class BookDetailResponsePojo {
    private Integer bookId;

    private String bookName;
    private String photo;

    private String isbn;


    private Integer noOfPages;

    private Date publishedDate;


    private double rating;

    private Integer stockCount;



    private Integer categoryId;
}
