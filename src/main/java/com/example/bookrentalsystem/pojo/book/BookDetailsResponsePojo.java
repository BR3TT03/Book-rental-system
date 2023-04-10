package com.example.bookrentalsystem.pojo.book;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookDetailsResponsePojo {
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

    private List<AuthorBasicDetailPojo> authorDetails;

}
