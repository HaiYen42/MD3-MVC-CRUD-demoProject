package view;

import config.Config;
import controller.CategoryController;
import model.Category;

import javax.swing.plaf.nimbus.AbstractRegionPainter;
import java.util.List;
import java.util.Scanner;

public class CategoryView {
    CategoryController categoryController = new CategoryController();
    List<Category> listCategory = new CategoryController().getListCategory();

    public void showListCategory() {
        System.out.println(listCategory);
    }

    public void formCreateCategory() {
        while (true) {
            listCategory = new CategoryController().getListCategory();
            int id = 1;
            if (listCategory.size() !=0) {
                id = listCategory.get(listCategory.size() - 1).getId() + 1;
            }
            System.out.println("Enter the name category ");
            String name = Config.scanner().nextLine();
            Category category = new Category(id, name);
            categoryController.createCategory(category);
            System.out.println("Create Successful !");
            System.out.println("Enter any key to continue or quit to return menu");
            String backMenu = Config.scanner().nextLine();
            if (backMenu.equalsIgnoreCase("quit")) {
                new NavBar();
                break;
            }
        }
    }
    public void formDeleteCategory() {
        System.out.println("Enter the id of item you want to delete");
        int id = Config.scanner().nextInt();
        Category category = categoryController.findById(id);
        if (category == null) {
            System.out.println(" Item is not exist ");
        } else {
            categoryController.deleteCategory(id);
            System.out.println("Delete successful !");
        }
    }
    public void editCategory(){
        System.out.println("Enter the id of item you want to edit");
        int id = Config.scanner().nextInt();
        Category category = categoryController.findById(id);
        if (category==null){
            System.out.println("Item you want to edit not exist ");
        } else {
            System.out.println("Enter the new name of product");
            String name = Config.scanner().nextLine();
            Category category1 = new Category(id, name);
            categoryController.createCategory(category1);
            System.out.println("Edit successful !");
            System.out.println("Enter any key to backMenu ");
            String backMenu = Config.scanner().nextLine();
                new NavBar();

        }
    }
}
