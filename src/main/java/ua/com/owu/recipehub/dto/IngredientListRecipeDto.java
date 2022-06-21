package ua.com.owu.recipehub.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class IngredientListRecipeDto {
    private int idIngredient;
    private String typeUkr;
    private String nameUkr;
    private int weight;
    private int calories;
    private List<Integer> recipes;
}
