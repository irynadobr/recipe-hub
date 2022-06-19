package ua.com.owu.recipehub.service.category;

import ua.com.owu.recipehub.models.Category;
import ua.com.owu.recipehub.models.Recipe;

import java.util.List;

public interface CategoryService {


    List<Category> getALLCategories();

    Category getCategory(int id);

    Category createCategory(Category category);

    Category updateCategory(int id, Category category);

    void deleteCategory(int id);
}
