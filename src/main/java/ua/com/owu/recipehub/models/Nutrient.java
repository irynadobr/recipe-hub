package ua.com.owu.recipehub.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Nutrient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    private String nameIngredient;
    private String nameNutrient;
    private double quantityNutrientIn100GramIngredient;

    @ManyToMany(mappedBy = "nutrient")
    private List<Ingredient> ingredients;

}
