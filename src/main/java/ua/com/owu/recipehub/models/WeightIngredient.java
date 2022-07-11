package ua.com.owu.recipehub.models;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
public class WeightIngredient {
    @EmbeddedId
    private IdRecipeIngredient idWeightIngredient;
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("ingredient_id")
    private Ingredient ingredient;
    @ManyToOne(fetch = FetchType.LAZY,cascade =CascadeType.MERGE)
    @MapsId("recipe_id")
    private Recipe recipe;
    @Column
    private int weightIngredient;


    public WeightIngredient(Recipe recipe, Ingredient ingredient, int weightIngredient) {
        this.ingredient = ingredient;
        this.recipe = recipe;
        this.weightIngredient = weightIngredient;
        this.idWeightIngredient = new IdRecipeIngredient(recipe.getId(), ingredient.getId());

    }


}
