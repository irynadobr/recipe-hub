package ua.com.owu.recipehub.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
