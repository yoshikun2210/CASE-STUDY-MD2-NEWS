package rikkei.academy.controller;

import rikkei.academy.model.category.Category;
import rikkei.academy.service.category.CategoryServiceIMPL;
import rikkei.academy.service.category.ICategoryService;

import java.util.List;

public class CategoryController {
    ICategoryService categoryService = new CategoryServiceIMPL();
    public List<Category> showListCategory() {
        return categoryService.findALl();
    }
    public void createCategory(Category category){
        categoryService.save(category);
    }
    public Category detailCategory(int id){
        return categoryService.findById(id);
    }
    public void updateCategory(int id , Category newCategory){
        Category category1 = categoryService.findById(id);
        category1.setNameCategory(newCategory.getNameCategory());
    }
    public void deleteCategory(int id){
        categoryService.deleteById(id);
    }
}
