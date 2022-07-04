package ua.com.owu.recipehub.service.nutrient;

import ua.com.owu.recipehub.dto.NutrientsListIngredientDTO;
import ua.com.owu.recipehub.models.Nutrient;

import java.util.List;

public interface NutrientService {
    List<NutrientsListIngredientDTO> getAllNutrients();

    Nutrient getNutrient(int id);


    Nutrient createNutrient(Nutrient nutrient);

    Nutrient updateNutrient(int id, Nutrient nutrient);

    void deleteNutrient(int id);
}
