package ua.com.owu.recipehub.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.com.owu.recipehub.dao.IngredientDao;
import ua.com.owu.recipehub.dto.IngredientDto;
import ua.com.owu.recipehub.dto.IngredientListNutrientsDto;
import ua.com.owu.recipehub.models.CategoryRecipe;
import ua.com.owu.recipehub.models.Ingredient;
import ua.com.owu.recipehub.models.Nutrient;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class IngredientServiceImpl implements IngredientService {
    @Autowired
    private IngredientDao ingredientDao;


//    @Override
//    public List<IngredientListRecipeDto> getAllIngredient() {
//        return ingredientDao.findAll();
//    }

    @Override
    public List<IngredientDto> getAllIngredient() {
        final List<Ingredient> ingredientDaoAll = ingredientDao.findAll();
        final List<IngredientDto> collect = ingredientDaoAll.stream()
                .map(ingredient -> {
                    IngredientDto ingredientDto = new IngredientDto();
                    ingredientDto.setIdIngredient(ingredient.getId());
                    ingredientDto.setTypeCategoryIngredientUkr(ingredient.getTypeCategoryIngredientUkr());
                    ingredientDto.setNameIngredientUkr(ingredient.getNameIngredientUkr());
                    ingredientDto.setTypeCategoryIngredient(ingredient.getTypeCategoryIngredient());
                    ingredientDto.setNameIngredient(ingredient.getNameIngredient());

                    final List<Integer> idRecipe = ingredient.getWeightIngredients().stream()
                            .map(x -> x.getRecipe().getId())
                            .collect(Collectors.toList());
                    ingredientDto.setRecipes(idRecipe);
                    return ingredientDto;

                }).collect(Collectors.toList());
        return collect;
    }

    @Override
    public IngredientDto getIngredient(int id) {

        final Ingredient ingredientDaoId = ingredientDao.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "No ingredient with id: " + id));

        IngredientDto ingredientDto = new IngredientDto();
        ingredientDto.setIdIngredient(ingredientDaoId.getId());
        ingredientDto.setNameIngredientUkr(ingredientDaoId.getNameIngredientUkr());
        ingredientDto.setTypeCategoryIngredientUkr(ingredientDaoId.getTypeCategoryIngredientUkr());
        ingredientDto.setNameIngredient(ingredientDaoId.getNameIngredient());
        ingredientDto.setTypeCategoryIngredient(ingredientDaoId.getTypeCategoryIngredient());
        final List<Integer> idRecipe = ingredientDaoId.getWeightIngredients()
                .stream()
                .map(x -> x.getRecipe().getId())
                .collect(Collectors.toList());
        ingredientDto.setRecipes(idRecipe);

        return ingredientDto;
    }

    @Override
    public IngredientDto createIngredient(IngredientDto ingredient) {

        Ingredient ingredientCreate = new Ingredient();
        ingredientCreate.setNameIngredientUkr(ingredient.getNameIngredientUkr());
        ingredientCreate.setTypeCategoryIngredientUkr(ingredient.getTypeCategoryIngredientUkr());
        ingredientCreate.setNameIngredient(ingredient.getNameIngredient());
        ingredientCreate.setTypeCategoryIngredient(ingredient.getTypeCategoryIngredient());
        ingredientDao.saveAndFlush(ingredientCreate);
        ingredient.setIdIngredient(ingredientCreate.getId());

        return ingredient;
    }

    @Override
    public IngredientDto updateIngredient(int id, IngredientDto ingredient) {

        if (!ingredientDao.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No ingredient found");
        }
        Ingredient ingredientUpdate =ingredientDao.findById(id).get();
        ingredientUpdate.setNameIngredientUkr(ingredient.getNameIngredientUkr());
        ingredientUpdate.setTypeCategoryIngredientUkr(ingredient.getTypeCategoryIngredientUkr());
        ingredientUpdate.setNameIngredient(ingredient.getNameIngredient());
        ingredientUpdate.setTypeCategoryIngredient(ingredient.getTypeCategoryIngredient());
           ingredientDao.saveAndFlush(ingredientUpdate);
        ingredient.setIdIngredient(id);
        return ingredient;
    }

    @Override
    public void deleteIngredient(int id) {
        if (!ingredientDao.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No ingredient found");
        }
        ingredientDao.deleteById(id);
    }


    @Override
    public List<IngredientListNutrientsDto> getAllIngredientWeightNutrientQuantity() {
        final List<Ingredient> ingredientNutrientDaoAll = ingredientDao.findAll();

        final List<IngredientListNutrientsDto> collectNutrient = ingredientNutrientDaoAll.stream()
                .map(ingredient -> {
                    IngredientListNutrientsDto ingredientListNutrientsDto = new IngredientListNutrientsDto();
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
