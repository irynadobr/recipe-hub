package ua.com.owu.recipehub.service;

import ua.com.owu.recipehub.models.Ingredient;

import java.util.List;

public interface IngredientService {
    Ingredient createIngredient(Ingredient ingredient);


    Ingredient updateIngredient(int id, Ingredient ingredient);


    List<Ingredient> getAllIngredient();

    void deleteIngredient(int id);

    Ingredient getIngredient(int ingredient);
}
