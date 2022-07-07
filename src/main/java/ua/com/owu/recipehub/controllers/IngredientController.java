package ua.com.owu.recipehub.controllers;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import ua.com.owu.recipehub.dto.IngredientListNutrientsDto;
import ua.com.owu.recipehub.dto.IngredientListRecipeDto;
import ua.com.owu.recipehub.models.Ingredient;
import ua.com.owu.recipehub.service.IngredientService;
import ua.com.owu.recipehub.validator.IngredientValidator;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/ingredient")

public class IngredientController {
    @Autowired
    private IngredientService ingredientService;
    @Autowired
    private IngredientValidator ingredientValidator;


//    @GetMapping(value = "")
//    public List<Ingredient> getIngredient() {
//        return ingredientService.getAllIngredient();
//    }
    @GetMapping(value = "")
    public List<IngredientListRecipeDto> getAllIngredient() {
        return ingredientService.getAllIngredient();
    }

    @GetMapping(value = "/weight")
    public List<IngredientListNutrientsDto> getIngredientWeightNutrientQuantity() {
        return ingredientService.getAllIngredientWeightNutrientQuantity();
    }

    @GetMapping(value = "/{id}")
    public IngredientListRecipeDto getIngredientById(@PathVariable int id) {
        return ingredientService.getIngredient(id);
    }

    @PostMapping(value = "")
    @ResponseStatus(HttpStatus.CREATED)
    public Ingredient insertIngredient(@RequestBody @Valid Ingredient ingredient) {
        return ingredientService.createIngredient(ingredient);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Ingredient updateIngredient(@PathVariable int id, @RequestBody @Valid Ingredient ingredient) {
        return ingredientService.updateIngredient(id, ingredient);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteIngredient(@PathVariable int id) {
        ingredientService.deleteIngredient(id);
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.addValidators(ingredientValidator);
    }
}
