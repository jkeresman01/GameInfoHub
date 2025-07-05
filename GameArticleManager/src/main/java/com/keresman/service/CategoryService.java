package com.keresman.service;

import com.keresman.dal.CategoryRepostitory;
import com.keresman.model.Category;
import com.keresman.validator.Result;
import java.util.List;

public class CategoryService {

    private final CategoryRepostitory categoryRepostitory;

    public CategoryService(CategoryRepostitory categoryRepostitory) {
        this.categoryRepostitory = categoryRepostitory;
    }

    public Result<List<Category>> getAllCategories() {
        try {
            List<Category> articles = categoryRepostitory.findAll();
            return Result.success(articles);
        } catch (Exception e) {
            return Result.error("Failed to fetch users.");
        }
    }
}
