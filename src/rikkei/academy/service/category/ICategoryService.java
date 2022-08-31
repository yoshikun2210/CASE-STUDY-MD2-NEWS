package rikkei.academy.service.category;

import rikkei.academy.model.category.Category;
import rikkei.academy.service.IGenericService;

public interface ICategoryService extends IGenericService<Category> {
   Category findById(int id);

    void deleteById(int id);
}
