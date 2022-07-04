package ua.com.owu.recipehub.service.categoryRecipe;

import ua.com.owu.recipehub.dto.CategoryListRecipeDto;
import ua.com.owu.recipehub.models.CategoryRecipe;

import java.util.List;

public interface CategoryRecipeService {


    List<CategoryListRecipeDto> getALLCategoriesRecipes();

    CategoryRecipe getCategoryRecipe(int id);

    CategoryRecipe createCategoryRecipe(CategoryRecipe categoryRecipe);

    CategoryRecipe updateCategoryRecipe(int id, CategoryRecipe categoryRecipe);

    void deleteCategoryRecipe(int id);
}
