package ua.com.owu.recipehub.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.com.owu.recipehub.dao.IngredientDao;
import ua.com.owu.recipehub.dto.IngredientListNutrientsDto;
import ua.com.owu.recipehub.dto.IngredientListRecipeDto;
import ua.com.owu.recipehub.dto.RecipeListIngredientDto;
import ua.com.owu.recipehub.models.Ingredient;
import ua.com.owu.recipehub.models.Nutrient;
import ua.com.owu.recipehub.models.Recipe;
import ua.com.owu.recipehub.models.WeightIngredient;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class IngredientServiceImpl implements IngredientService {
    @Autowired
    private IngredientDao ingredientDao;

    @Override
    public Ingredient createIngredient(Ingredient ingredient) {
        return ingredientDao.saveAndFlush(ingredient);
    }

    @Override
    public Ingredient updateIngredient(int id, Ingredient ingredient) {
        ingredient.setId(id);
        if (!ingredientDao.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No ingredient found");
        }
        return ingredientDao.saveAndFlush(ingredient);
    }

//    @Override
//    public List<IngredientListRecipeDto> getAllIngredient() {
//        return ingredientDao.findAll();
//    }

    @Override
    public List<IngredientListRecipeDto>  getAllIngredient(){
        final List<Ingredient>ingredientDaoAll =ingredientDao.findAll();
        final List<IngredientListRecipeDto> collect = ingredientDaoAll.stream()
                .map(ingredient -> {
                    IngredientListRecipeDto ingredientListRecipeDto  = new IngredientListRecipeDto();
                    ingredientListRecipeDto.setIdIngredient(ingredient.getId());
                    ingredientListRecipeDto.setTypeCategoryIngredientUkr(ingredient.getTypeCategoryIngredientUkr());
                    ingredientListRecipeDto.setNameIngredientUkr(ingredient.getNameIngredientUkr());
//                            ingredient.getQuantityIngredients()
//                            .stream().map(QuantityIngredient::getId).filter(x->x.getIngredient_id()== ingredient.getId())



//                          final List<Integer> idRecipe = ingredient.getRecipes().stream()
//                            .map(Recipe::getId)
//                            .collect(Collectors.toList());
//                    ingredientListRecipeDto.setRecipes(idRecipe);
                    return ingredientListRecipeDto;

                }).collect(Collectors.toList());
        return collect;
    }


    @Override
    public void deleteIngredient(int id) {
        if (!ingredientDao.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No ingredient found");
        }
        ingredientDao.deleteById(id);
    }

    @Override
    public Ingredient getIngredient(int id) {
       return ingredientDao.findById(id).orElseThrow(() ->new ResponseStatusException(HttpStatus.BAD_REQUEST, "No ingredient with id: " + id));
    }

    @Override
    public List<IngredientListNutrientsDto> getAllIngredientWeightNutrientQuantity() {
        final List<Ingredient>ingredientNutrientDaoAll =ingredientDao.findAll();

        final List<IngredientListNutrientsDto> collectNutrient = ingredientNutrientDaoAll.stream()
                .map(ingredient -> {
                    IngredientListNutrientsDto ingredientListNutrientsDto  = new IngredientListNutrientsDto();
                    ingredientListNutrientsDto.setIdIngredient(ingredient.getId());
                    ingredientListNutrientsDto.setTypeCategoryIngredientUkr(ingredient.getTypeCategoryIngredientUkr());
                    ingredientListNutrientsDto.setNameIngredientUkr(ingredient.getNameIngredientUkr());

                    final List<Integer> idNutrient = ingredient.getNutrient().stream()
                            .map(Nutrient::getId)
                            .collect(Collectors.toList());
                    ingredientListNutrientsDto.setNutrient(idNutrient);
//                    final List<Integer> idRecipe = ingredient.getRecipes().stream()
//                            .map(Recipe::getId)
//                            .collect(Collectors.toList());
//                    ingredientListNutrientsDto.setRecipes(idRecipe);
                    return ingredientListNutrientsDto;
                }).collect(Collectors.toList());
        return collectNutrient;
    }

}
