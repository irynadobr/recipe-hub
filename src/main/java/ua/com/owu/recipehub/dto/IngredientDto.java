package ua.com.owu.recipehub.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class IngredientDto {

    private int idIngredient;
    private String typeCategoryIngredientUkr;
    private String nameIngredientUkr;
    private String typeCategoryIngredient;
    private String nameIngredient;
    private List<Integer> recipes;

    public IngredientDto(int idIngredient, String typeCategoryIngredientUkr, String nameIngredientUkr,
                         String typeCategoryIngredient, String nameIngredient) {
        this.idIngredient = idIngredient;
        this.typeCategoryIngredientUkr=typeCategoryIngredientUkr;
        this.nameIngredientUkr=nameIngredientUkr;
        this.typeCategoryIngredient=typeCategoryIngredient;
        this.nameIngredient=nameIngredient;
    }

}
