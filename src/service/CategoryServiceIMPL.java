package service;

import config.Config;
import model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryServiceIMPL implements ICategoryService {

    //Đọc file từ category để lấy 1 list
    List<Category> categoryList = new Config<Category>().readFromFile(Config.PATH_CATEGORY);

    @Override
    public List<Category> findAll() {
        return categoryList;
    }

    @Override
    public void save(Category category) {
        Category category1= findById(category.getId());
        if (category1 == null) {
            categoryList.add(category);
        }else {
            int index= categoryList.indexOf(category1);
            categoryList.set(index,category);
        }
        new Config<Category>().writeToFile(Config.PATH_CATEGORY, categoryList);
    }

    @Override
    public Category findById(int id) {
        for (int i = 0; i < categoryList.size(); i++) {
            if (id == categoryList.get(i).getId()) {
                return categoryList.get(i);
            }
        }
        return null;
    }
    
    @Override
    public void deleteById(int id) {
        for (int i = 0; i < categoryList.size(); i++) {
            if (id == categoryList.get(i).getId()){
                categoryList.remove(i);
            }
        }
        new Config<Category>().writeToFile(Config.PATH_CATEGORY, categoryList);
    }

}
