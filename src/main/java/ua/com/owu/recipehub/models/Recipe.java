package ua.com.owu.recipehub.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import ua.com.owu.recipehub.dto.RecipeDto;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Recipe  {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String imageRecipe;
    private String titleRecipe;
    @ManyToOne(targetEntity = User.class)
//    @JsonIgnore
    private User authorRecipe;
    private String descriptionRecipe;
    //    @ManyToOne(cascade = CascadeType.ALL,  targetEntity = CategoryRecipe.class)
    @ManyToOne(targetEntity = CategoryRecipe.class)
//    @JsonIgnore
    private CategoryRecipe categoryRecipe;
    @ManyToMany(cascade = CascadeType.ALL, targetEntity = Ingredient.class)
    @JoinTable(name = "recipeIngredient", joinColumns = @JoinColumn(name = "recipe_id"), inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
    @JsonIgnore
    private List<Ingredient> ingredients;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WeightIngredient> weightIngredients;
    private double rating;

//    public Recipe(String imageRecipe, String titleRecipe, User authorRecipe, String descriptionRecipe,  CategoryRecipe categoryRecipe,
//                  List<Ingredient>ingredients,
//                  List<WeightIngredient>weightIngredients, double rating) {
//        this.imageRecipe = imageRecipe;
//        this.titleRecipe = titleRecipe;
//        this.authorRecipe = authorRecipe;
//        this.descriptionRecipe=descriptionRecipe;
//
//        this.categoryRecipe = categoryRecipe;
//      this.ingredients=ingredients;
//      this.weightIngredients=weightIngredients;
//      this.rating=rating;
//
//    }

}
