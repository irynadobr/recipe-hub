package ua.com.owu.recipehub.service.recipe;

import ua.com.owu.recipehub.dto.RecipeDto;
import ua.com.owu.recipehub.dto.RecipePage;
import ua.com.owu.recipehub.models.Recipe;

public interface RecipeService {
    RecipeDto createRecipe(RecipeDto recipe);


    Recipe updateRecipe(int id, Recipe recipe);

    void deleteRecipe(int id);

    RecipePage getALLRecipes(int page, int size);

    RecipeDto getRecipe(int id);
}
