package ua.com.owu.recipehub.dto;

import lombok.*;
import ua.com.owu.recipehub.models.Ingredient;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class IngredientListRecipeDto  {
    private int idIngredient;
    private String typeCategoryIngredientUkr;
    private String nameIngredientUkr;
    private String typeCategoryIngredient;
    private String nameIngredient;

    private int weightIngredient;
    private List<Integer> recipes;

//    public IngredientListRecipeDto(Ingredient ingredient, int weightIngredient) {
//        this.idIngredient=ingredient.getId();
//        this.typeCategoryIngredientUkr=ingredient.getTypeCategoryIngredientUkr();
//        this.nameIngredientUkr=ingredient.getNameIngredientUkr();
//        this.weightIngredient=weightIngredient;
//    }
}

