package ua.com.owu.recipehub.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class IngredientListNutrientsDto {
    private int idIngredient;
    private String typeCategoryIngredientUkr;
    private String nameIngredientUkr;
    private int weightIngredient;
    private List<Integer> nutrient;
}
