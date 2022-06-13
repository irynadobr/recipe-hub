package ua.com.owu.recipehub.service.recipe;

import ua.com.owu.recipehub.models.Recipe;

import java.util.List;

public interface RecipeService {
    Recipe createRecipe(Recipe recipe);


    Recipe updateRecipe(int id, Recipe recipe);

    void deleteRecipe(int id);

    List<Recipe> getALLRecipes();

    Recipe getRecipe(int id);
}
