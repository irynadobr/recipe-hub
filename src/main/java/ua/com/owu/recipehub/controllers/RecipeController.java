package ua.com.owu.recipehub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ua.com.owu.recipehub.models.Ingredient;
import ua.com.owu.recipehub.models.Recipe;
import ua.com.owu.recipehub.service.IngredientService;
import ua.com.owu.recipehub.service.recipe.RecipeService;

import java.util.List;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
    @Autowired
    private RecipeService recipeService;

    @GetMapping(value = "")
    public List<Recipe> getRecipes() {
        return recipeService.getALLRecipes();
    }

    @GetMapping(value = "/{id}")
    public Recipe getByIdRecipe(@PathVariable int id){
        return recipeService.getRecipe(id);
    }

    @PostMapping(value = "")
    @ResponseStatus(HttpStatus.CREATED)
    public Recipe insertRecipe(@RequestBody Recipe recipe) {
        return recipeService.createRecipe(recipe);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Recipe updateRecipe(@PathVariable int id, @RequestBody Recipe recipe) {
        return recipeService.updateRecipe(id, recipe);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRecipe(@PathVariable int id) {
        recipeService.deleteRecipe(id);
    }
}
