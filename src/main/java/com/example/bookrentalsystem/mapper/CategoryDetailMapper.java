package com.example.bookrentalsystem.mapper;

import com.example.bookrentalsystem.pojo.category.CategoryDetailResponsePojo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface CategoryDetailMapper {
    @Select("select * from tbl_category where \"category_id\"= #{categoryId}")
    Object findCategoryById(Integer categoryId);

    @Select("select category_id as categoryId,category_description as categoryDescription,category_name as categoryName from tbl_category")
    List<CategoryDetailResponsePojo> getAllCategory();

    @Select("select category_id as categoryId,category_description as categoryDescription,category_name as categoryName from tbl_category where \"category_id\"= #{categoryId}")
    Optional<CategoryDetailResponsePojo> getCategoryById(Integer categoryId);
}
