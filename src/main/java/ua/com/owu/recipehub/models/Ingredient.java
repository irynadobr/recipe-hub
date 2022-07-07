
package ua.com.owu.recipehub.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    private String typeCategoryIngredientUkr;
    private String nameIngredientUkr;
    private String typeCategoryIngredient;
    private String nameIngredient;

//    @OneToMany(
//            mappedBy = "ingredient",
//            orphanRemoval = true,
//            cascade = CascadeType.ALL)


//    @ManyToMany(mappedBy = "ingredients")
//    @JsonIgnore
//    private List<Recipe> recipes;


    @OneToMany(mappedBy = "ingredient",
            orphanRemoval = true, cascade = CascadeType.ALL)
    private List<WeightIngredient> weightIngredients = new ArrayList<>();
    @ManyToMany(targetEntity = Nutrient.class)
    @JoinTable(name = "ingredientNutrient",
            joinColumns = @JoinColumn(name = "ingredient_id"),
            inverseJoinColumns = @JoinColumn(name = "nutrient_id"))
    private List<Nutrient> nutrient;

    public Ingredient(
            String typeCategoryIngredientUkr,
            String nameIngredientUkr,
            String typeCategoryIngredient,
            String nameIngredient,
            List<Recipe> recipes,
            List<WeightIngredient> weightIngredients
    ) {
        this.typeCategoryIngredientUkr = typeCategoryIngredientUkr;
        this.nameIngredientUkr = nameIngredientUkr;
        this.typeCategoryIngredient = typeCategoryIngredient;
        this.nameIngredient = nameIngredient;
//        this.recipes = recipes;
        this.weightIngredients = weightIngredients;

    }
}
