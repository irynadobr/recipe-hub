package ua.com.owu.recipehub.service;

import ua.com.owu.recipehub.dto.IngredientDto;
import ua.com.owu.recipehub.dto.IngredientListNutrientsDto;

import java.util.List;

public interface IngredientService {
    IngredientDto createIngredient( IngredientDto ingredient);


    IngredientDto updateIngredient(int id,  IngredientDto ingredient);


    List<IngredientDto> getAllIngredient();

    void deleteIngredient(int id);

    IngredientDto getIngredient(int id);

    List<IngredientListNutrientsDto> getAllIngredientWeightNutrientQuantity();
}
