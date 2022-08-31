package rikkei.academy.service.category;

import rikkei.academy.config.Config;
import rikkei.academy.model.category.Category;

import java.util.List;

public class CategoryServiceIMPL implements ICategoryService {
    public static final String PATH_CATEGORY = "D:\\New folder\\untitled8\\src\\rikkei\\academy\\database\\category.txt";
    public static List<Category> categoryList = new Config<Category>().readFile(PATH_CATEGORY);

//    static {
//        categoryList.add(new Category(1, "Becze"));
//        categoryList.add(new Category(2, "Chihuahua"));
//        categoryList.add(new Category(3, "Bull"));
//    }

    @Override
    public List<Category> findALl() {
        new Config<Category>().writeFile(PATH_CATEGORY,categoryList);
        return categoryList;
    }

    @Override
    public void save(Category category) {
        categoryList.add(category);
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
            if (id == categoryList.get(i).getId()) {
                categoryList.remove(i);
                break;
            }
        }
    }
}
