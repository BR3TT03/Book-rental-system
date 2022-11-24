package com.example.bookrentalsystem.service.category;

import com.example.bookrentalsystem.globalException.AppException;
import com.example.bookrentalsystem.model.Category;
import com.example.bookrentalsystem.pojo.category.CategoryDetailRequestPojo;
import com.example.bookrentalsystem.pojo.category.CategoryDetailResponsePojo;

import java.util.List;

public interface CategoryService {
    CategoryDetailResponsePojo getCategoryById(Integer categoryId) throws AppException;
    void saveCategoryDetails(CategoryDetailRequestPojo categoryDetailRequestPojo);
     List<CategoryDetailResponsePojo> getCategory();

    void deleteCateoryById(Integer categoryId) throws AppException;
}
