package ua.com.owu.recipehub.service;

import ua.com.owu.recipehub.dto.IngredientListRecipeDto;
import ua.com.owu.recipehub.models.Ingredient;

import java.util.List;

public interface IngredientService {
    Ingredient createIngredient(Ingredient ingredient);


    Ingredient updateIngredient(int id, Ingredient ingredient);


    List<IngredientListRecipeDto> getAllIngredient();

    void deleteIngredient(int id);

    Ingredient getIngredient(int id);
}
