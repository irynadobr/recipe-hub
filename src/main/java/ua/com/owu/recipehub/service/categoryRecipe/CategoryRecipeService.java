package ua.com.owu.recipehub.service.categoryRecipe;

import ua.com.owu.recipehub.dto.CategoryListRecipeDto;
import ua.com.owu.recipehub.dto.CategoryRecipeDto;

import java.util.List;

public interface CategoryRecipeService {


    List<CategoryListRecipeDto> getALLCategoriesRecipes();

    CategoryListRecipeDto getCategoryRecipe(int id);

    CategoryRecipeDto createCategoryRecipe(CategoryRecipeDto categoryRecipe);

    CategoryRecipeDto updateCategoryRecipe(int id, CategoryRecipeDto categoryRecipe);

    void deleteCategoryRecipe(int id);
}
