package ua.com.owu.recipehub.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.com.owu.recipehub.models.Ingredient;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class IngredientListRecipeDto {
    private int idIngredient;
    private String typeCategoryIngredientUkr;
    private String nameIngredientUkr;
    private int weightIngredient;
    private List<Integer> recipes;

//    public IngredientListRecipeDto(Ingredient ingredient, int weightIngredient) {
//        this.idIngredient=ingredient.getId();
//        this.typeCategoryIngredientUkr=ingredient.getTypeCategoryIngredientUkr();
//        this.nameIngredientUkr=ingredient.getNameIngredientUkr();
//        this.weightIngredient=weightIngredient;
//    }
}

