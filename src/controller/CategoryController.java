package controller;

import model.Category;
import service.CategoryServiceIMPL;
import service.ICategoryService;

import java.util.List;

public class CategoryController {
    ICategoryService categoryService = new CategoryServiceIMPL();
    public List<Category> getListCategory(){
        return categoryService.findAll();
    }
    public void createCategory(Category category){
        categoryService.save(category);
    }
    public Category findById(int id){
       return categoryService.findById(id);
    }
    public void deleteCategory (int id){
        categoryService.deleteById(id);
    }
}
