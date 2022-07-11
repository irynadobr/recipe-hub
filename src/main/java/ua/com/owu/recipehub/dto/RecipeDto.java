package ua.com.owu.recipehub.dto;

import lombok.*;
import ua.com.owu.recipehub.models.Recipe;
import ua.com.owu.recipehub.models.WeightIngredient;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RecipeDto {
    private int idRecipe;
    private String imageRecipe;
    private String titleRecipe;
    private int idAuthorRecipe;
    private String descriptionRecipe;
    private int idCategoryRecipe;
    private List<RecipeListIngredientDto> ingredients;
    private double rating;


    public RecipeDto(Recipe recipe) {
        this.idRecipe = recipe.getId();
        this.titleRecipe = recipe.getTitleRecipe();
        this.descriptionRecipe = recipe.getDescriptionRecipe();
        this.imageRecipe = recipe.getImageRecipe();
        this.idAuthorRecipe = recipe.getAuthorRecipe().getIdUser();
        this.idCategoryRecipe = recipe.getCategoryRecipe().getId();
        this.ingredients = recipe.getWeightIngredients()
                .stream()
                .map(x -> new RecipeListIngredientDto(x.getIngredient().getId(), x.getIngredient().getNameIngredientUkr(), x.getWeightIngredient())).collect(Collectors.toList());
        this.rating = recipe.getRating();

    }


//        this.ingredients=recipe.getWeightIngredients()
//                .stream()
//                .map(x->new RecipeListIngredientDto(x.getIngredient().getId(),x.getWeightIngredient()))
//                .collect(Collectors.toList());
//        this.rating=recipe.getRating();


}

