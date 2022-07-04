package ua.com.owu.recipehub.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ua.com.owu.recipehub.dto.NutrientsListIngredientDTO;
import ua.com.owu.recipehub.models.Nutrient;
import ua.com.owu.recipehub.service.nutrient.NutrientService;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/nutrient")
@AllArgsConstructor
public class NutrientController {

    @Autowired
    private NutrientService nutrientService;


    @GetMapping(value = "")
    public List<NutrientsListIngredientDTO> getNutrient() {
        return nutrientService.getAllNutrients();
    }

    @GetMapping(value = "/{id}")
    public Nutrient getById(@PathVariable int id){
        return nutrientService.getNutrient(id);
    }

    @PostMapping(value = "")
    @ResponseStatus(HttpStatus.CREATED)
    public Nutrient insertNutrient(@RequestBody @Valid Nutrient nutrient) {
        return nutrientService.createNutrient(nutrient);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Nutrient updateNutrient(@PathVariable int id, @RequestBody @Valid Nutrient nutrient) {
        return nutrientService.updateNutrient(id, nutrient);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteNutrient(@PathVariable int id) {
        nutrientService.deleteNutrient(id);
    }




}
