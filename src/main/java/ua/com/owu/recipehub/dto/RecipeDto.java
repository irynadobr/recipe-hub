package ua.com.owu.recipehub.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.com.owu.recipehub.models.Recipe;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RecipeDto  {
    private int idRecipe;
    private String imageRecipe;
    private String titleRecipe;
    private int idAuthorRecipe;
    private String descriptionRecipe;
    private int idCategoryRecipe;
    private List <RecipeListIngredientDto> ingredients;
    private double rating;



    public RecipeDto(Recipe recipe) {
        this.idRecipe=recipe.getId();
        this.imageRecipe=recipe.getImageRecipe();
        this.idAuthorRecipe=recipe.getAuthorRecipe().getIdUser();
        this.idCategoryRecipe=recipe.getCategoryRecipe().getId();
        this.ingredients=new ArrayList<RecipeListIngredientDto>()
                .stream()
                .map(x->new RecipeListIngredientDto(x.getIngredientId(),x.getNameIngredientUkr(),x.getWeightIngredient())).collect(Collectors.toList());
        this.rating=recipe.getRating();
//        this.ingredients=recipe.getWeightIngredients()
//                .stream()
//                .map(x->new RecipeListIngredientDto(x.getIngredient().getId(),x.getWeightIngredient()))
//                .collect(Collectors.toList());
//        this.rating=recipe.getRating();
    }

}

