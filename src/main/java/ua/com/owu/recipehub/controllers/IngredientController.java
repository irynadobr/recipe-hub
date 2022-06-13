package ua.com.owu.recipehub.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ua.com.owu.recipehub.dao.UserDao;
import ua.com.owu.recipehub.models.Ingredient;
import ua.com.owu.recipehub.service.IngredientService;

import java.util.List;

@RestController
@RequestMapping("/ingredient")
public class IngredientController {
    @Autowired
    private IngredientService ingredientService;

    @GetMapping(value = "")
    public List<Ingredient> getIngredient() {
        return ingredientService.getAllIngredient();
    }

    @GetMapping(value = "/{id}")
    public Ingredient getById(@PathVariable int id){
        return ingredientService.getIngredient(id);
    }

    @PostMapping(value = "")
    @ResponseStatus(HttpStatus.CREATED)
    public Ingredient insertIngredient(@RequestBody Ingredient ingredient) {
        return ingredientService.createIngredient(ingredient);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Ingredient updateIngredient(@PathVariable int id, @RequestBody Ingredient ingredient) {
        return ingredientService.updateIngredient(id, ingredient);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteIngredient(@PathVariable int id) {
        ingredientService.deleteIngredient(id);
    }
}
