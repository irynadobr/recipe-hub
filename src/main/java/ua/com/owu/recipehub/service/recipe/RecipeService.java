package ua.com.owu.recipehub.service.recipe;

import ua.com.owu.recipehub.dto.RecipeDto;
import ua.com.owu.recipehub.dto.RecipePage;

public interface RecipeService {
    RecipeDto createRecipe(RecipeDto recipe);


    RecipeDto updateRecipe(int id, RecipeDto recipe);

    void deleteRecipe(int id);

    RecipePage getALLRecipes(int page, int size);

    RecipeDto getRecipe(int id);
}
