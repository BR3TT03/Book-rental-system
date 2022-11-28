package com.example.bookrentalsystem.pojo.book;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AuthorBasicDetailPojo {
    private Integer authorId;
    private String authorName;

}
