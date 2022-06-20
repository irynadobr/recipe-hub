package ua.com.owu.recipehub.service.category;

import ua.com.owu.recipehub.dto.CategoryListRecipeDto;
import ua.com.owu.recipehub.models.Category;

import java.util.List;

public interface CategoryService {


    List<CategoryListRecipeDto> getALLCategories();

    Category getCategory(int id);

    Category createCategory(Category category);

    Category updateCategory(int id, Category category);

    void deleteCategory(int id);
}
