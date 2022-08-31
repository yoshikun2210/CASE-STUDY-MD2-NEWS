package rikkei.academy.view.category;

import rikkei.academy.config.Config;
import rikkei.academy.controller.CategoryController;
import rikkei.academy.model.category.Category;
import rikkei.academy.view.Main;

import java.util.List;

public class ViewCategory {
    public CategoryController categoryController = new CategoryController();
    public List<Category> categoryList = categoryController.showListCategory();

    public ViewCategory() {
        System.out.println("|      * * CATEGORY MANAGER * *    |");
        System.out.println("1.Create Category");
        System.out.println("2.Show List Category");
        System.out.println("3.Detail Category");
        System.out.println("4.Edit Category");
        System.out.println("5.Delete Category");
        System.out.println("6.Back Menu");
        int chooseCategory = Config.scanner().nextInt();
        switch (chooseCategory) {
            case 1:
                newsCreateCategory();
                break;
            case 2:
                newsShowListCategory();
                break;
            case 3:
                newsDetailCategory();
                break;
            case 4:
                newsEditCategory();
                break;
            case 5:
                newsDeleteCategory();
                break;
            case 6:
               new Main();
               break;

        }
    }
// CREATE
    public void newsCreateCategory() {
        System.out.println("|________ CREATE CATEGORY ________|");
        while (true) {
            int idCategory;
            if (categoryList.size() == 0) {
                idCategory = 1;
            } else {
                idCategory = categoryList.get(categoryList.size() - 1).getId() + 1;
            }
            System.out.println("Nhập vào tên chủ đề :");
            String name = Config.scanner().nextLine();
            Category category = new Category(idCategory, name);
            categoryController.createCategory(category);
            System.out.println("Thêm thành công!!!");
            System.out.println("Nhập phím bất kỳ đề tiếp tục - out để thoát");
            String outHome = Config.scanner().nextLine();
            if (outHome.equalsIgnoreCase("out")) {
                new ViewCategory();
                break;

            }
        }

    }

// SHOW LIST
    public void newsShowListCategory() {
        System.out.println("|     STT     CHỦ DỀ     |");
        for (int i = 0; i < categoryList.size(); i++) {
            int j = i + 1;
            System.out.println("|     " + j + "     " + categoryList.get(i).getNameCategory() + "      |");
        }
        System.out.println("Nhập out để thoát");
        String outHome = Config.scanner().nextLine();
        if (outHome.equalsIgnoreCase("out")) {
            new ViewCategory();
        }

    }

// DETAIL
    public void newsDetailCategory() {
        System.out.println("Nhập id:");
        int idCategory = Config.scanner().nextInt();
        if (categoryController.detailCategory(idCategory) == null) {
            System.out.println("Không có id này");
        } else {
            Category category = categoryController.detailCategory(idCategory);
            System.out.println(category);
        }
        System.out.println("Nhập out để thoát");
        String outHome = Config.scanner().nextLine();
        if (outHome.equalsIgnoreCase("out")) {
            new ViewCategory();
        }

    }
    // EDIT
    public void newsEditCategory() {
        System.out.println("Nhập id để sửa");
        int idCategory = Config.scanner().nextInt();
        if (categoryController.detailCategory(idCategory)==null) {
            System.out.println("Không có id này");
        } else {
            Category category= categoryController.detailCategory(idCategory);
            System.out.println("Old name :" + category.getNameCategory());
            System.out.println("Nhập để sửa :");
            String newName = Config.scanner().nextLine();
            if (newName.trim().equals("")) {
                newName = category.getNameCategory();
            }
            Category newCategory = new Category(newName);
            categoryController.updateCategory(idCategory, newCategory);
            System.out.println("Sửa thành công !!!!!!");
            newsShowListCategory();
        }
        System.out.println("Nhập out để thoát");
        String outHome = Config.scanner().nextLine();
        if (outHome.equalsIgnoreCase("out")) {
            new ViewCategory();
        }

    }



// DELETE
    public void newsDeleteCategory() {

        System.out.println("Nhập id để xóa");
        int idCategory = Config.scanner().nextInt();
        if (categoryController.detailCategory(idCategory) == null) {
            System.out.println("Không có id này");
        } else {
            System.out.println("Nhập 1 để xóa - Nhập 2 để không xóa");
            int chooseDelete = Config.scanner().nextInt();
            switch (chooseDelete) {
                case 1:
                    System.out.println("Xóa thành công!!!!");
                    categoryController.deleteCategory(idCategory);
                    newsShowListCategory();
                    break;
                case 2:
                    new ViewCategory();
                    break;
            }
        }
    }

}

