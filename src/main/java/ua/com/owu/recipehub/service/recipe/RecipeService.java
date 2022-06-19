package ua.com.owu.recipehub.service.recipe;

import org.springframework.data.domain.Page;
import ua.com.owu.recipehub.dto.RecipeDto;
import ua.com.owu.recipehub.dto.RecipePage;
import ua.com.owu.recipehub.models.Recipe;

import java.util.List;

public interface RecipeService {
    RecipeDto createRecipe(RecipeDto recipe);


    Recipe updateRecipe(int id, Recipe recipe);

    void deleteRecipe(int id);

    RecipePage getALLRecipes(int page, int size);

    Recipe getRecipe(int id);
}
