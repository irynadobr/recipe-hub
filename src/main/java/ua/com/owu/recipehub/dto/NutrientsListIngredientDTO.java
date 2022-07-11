package ua.com.owu.recipehub.dto;

import lombok.*;

import javax.persistence.Id;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class NutrientsListIngredientDTO {
    @Id
    private int idNutrient;
    private String nameNutrient;
    private List<Integer> ingredients;
}
