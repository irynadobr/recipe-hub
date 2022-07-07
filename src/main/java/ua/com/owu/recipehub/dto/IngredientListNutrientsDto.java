package ua.com.owu.recipehub.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class IngredientListNutrientsDto {
    private int idIngredient;
    private String typeCategoryIngredientUkr;
    private String nameIngredientUkr;
    private int weightIngredient;
    private List<Integer> nutrient;
}
