package ua.com.owu.recipehub.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ua.com.owu.recipehub.dto.RecipeDto;
import ua.com.owu.recipehub.dto.RecipePage;
import ua.com.owu.recipehub.models.Recipe;
import ua.com.owu.recipehub.service.recipe.RecipeService;

@RestController
@RequestMapping("/recipe")
@AllArgsConstructor
public class RecipeController {
    @Autowired
    private RecipeService recipeService;

    @GetMapping(value = "")
    public RecipePage getRecipes(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return recipeService.getALLRecipes(page, size);
    }

    @GetMapping(value = "/{id}")
    public RecipeDto getByIdRecipe(@PathVariable int id) {
        return recipeService.getRecipe(id);
    }

//    @PostMapping(value = "")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Recipe insertRecipe(@RequestBody Recipe recipe) {
//        return recipeService.createRecipe(recipe);
//    }

    @PostMapping(value = "")
    @ResponseStatus(HttpStatus.CREATED)
    public RecipeDto insertRecipe(@RequestBody RecipeDto recipe) {
        return recipeService.createRecipe(recipe);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public RecipeDto updateRecipe(@PathVariable int id, @RequestBody RecipeDto recipe) {
        return recipeService.updateRecipe(id, recipe);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRecipe(@PathVariable int id) {
        recipeService.deleteRecipe(id);
    }
}
