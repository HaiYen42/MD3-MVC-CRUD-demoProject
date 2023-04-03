package view;

import config.Config;

public class NavBar {
    //Xây dựng menu
    // B1: Tạo Contructor
    public NavBar() {
        System.out.println("*********CATEGORY MANAGER***********");
        System.out.println("1. Show List Category ");
        System.out.println("2. Create Category ");
        System.out.println("3. Edit Category Name ");
        System.out.println("4. Edit Category Status");
        System.out.println("5. Delete Category item ");
        int chooseMenu;
        do {
            System.out.println("Choose your option !");
            chooseMenu = Config.scanner().nextInt();
            switch (chooseMenu) {
                case 1:
                    new CategoryView().showListCategory();
                    break;
                case 2:
                    new CategoryView().formCreateCategory();
                    break;
                case 3:
                    new CategoryView().editCategory();
                    break;
                case 4:
                    break;
                case 5:
                    new CategoryView().formDeleteCategory();
                    break;
                case 6:
                    System.out.println("Thoát khỏi chương trình");
                    System.exit(1);
            }

        } while (chooseMenu != 6);

    }

    public static void main(String[] args) {
        new NavBar();
    }
}