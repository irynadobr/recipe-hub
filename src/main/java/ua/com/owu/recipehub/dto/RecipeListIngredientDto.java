package ua.com.owu.recipehub.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RecipeListIngredientDto {
    private int ingredientId;
    private String nameIngredientUkr;
    private int weightIngredient;


    public RecipeListIngredientDto(IngredientListRecipeDto ingredientListRecipeDto) {
        this.ingredientId = ingredientListRecipeDto.getIdIngredient();
        this.nameIngredientUkr = ingredientListRecipeDto.getNameIngredientUkr();
        this.weightIngredient = ingredientListRecipeDto.getWeightIngredient();
    }
}
