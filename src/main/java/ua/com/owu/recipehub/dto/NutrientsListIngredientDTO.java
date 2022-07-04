package ua.com.owu.recipehub.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class NutrientsListIngredientDTO {
    @Id
    private int idNutrient;
    private String nameNutrient;
    private List<Integer> ingredients;
}
