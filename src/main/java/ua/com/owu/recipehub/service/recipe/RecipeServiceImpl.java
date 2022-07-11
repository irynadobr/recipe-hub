package ua.com.owu.recipehub.service.recipe;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.com.owu.recipehub.dao.CategoryRecipeDao;
import ua.com.owu.recipehub.dao.IngredientDao;
import ua.com.owu.recipehub.dao.RecipeDao;
import ua.com.owu.recipehub.dao.UserDao;
import ua.com.owu.recipehub.dto.*;
import ua.com.owu.recipehub.models.Ingredient;
import ua.com.owu.recipehub.models.Recipe;
import ua.com.owu.recipehub.models.WeightIngredient;
import ua.com.owu.recipehub.service.IngredientService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RecipeServiceImpl implements RecipeService {
    @Autowired
    private RecipeDao recipeDao;

    @Autowired
    private CategoryRecipeDao categoryRecipeDao;
    //    @Autowired
//    private CategoryRecipeService categoryRecipeService;
//    @Autowired
//    private UserService userService;
    @Autowired
    private UserDao userDao;
    @Autowired
    private IngredientDao ingredientDao;


    //    @Override
//    public List<Recipe> getALLRecipes() {
//        return recipeDao.findAll();
//    }
    @Override
    public RecipePage getALLRecipes(int page, int size) {
        final Page<Recipe> recipes = recipeDao.findAll(PageRequest.of(page, size));
        final RecipePage recipePage = new RecipePage();
        final List<Recipe> content = recipes.getContent();
        recipePage.setRecipes(content.stream().map(recipe -> {
            RecipeDto recipeDto = new RecipeDto();
            recipeDto.setIdRecipe(recipe.getId());
            recipeDto.setImageRecipe(recipe.getImageRecipe());
            recipeDto.setTitleRecipe(recipe.getTitleRecipe());
            recipeDto.setIdAuthorRecipe(recipe.getAuthorRecipe().getIdUser());
            recipeDto.setDescriptionRecipe(recipe.getDescriptionRecipe());
            recipeDto.setIdCategoryRecipe(recipe.getCategoryRecipe().getId());
            final List<RecipeListIngredientDto> ingredientWithRecipe = recipe.getWeightIngredients()
                    .stream()
                    .map(x -> new RecipeListIngredientDto(x.getIngredient().getId(),
                            x.getIngredient().getNameIngredientUkr(),
                            x.getWeightIngredient()))
                    .collect(Collectors.toList());
            recipeDto.setIngredients(ingredientWithRecipe);
            recipeDto.setRating(recipe.getRating());
            return recipeDto;
        }).collect(Collectors.toList()));
        recipePage.setCurrentPage(recipes.getNumber());
        recipePage.setLast(recipes.isLast());
        recipePage.setTotalPage(recipes.getTotalPages());
        recipePage.setTotalElements(recipes.getTotalElements());
        return recipePage;
    }

    @Override
    public RecipeDto getRecipe(int id) {
        final Recipe recipeDaoId = recipeDao.findById(id)
                .orElseThrow(() -> new RuntimeException());
        RecipeDto recipeDto = new RecipeDto();
        recipeDto.setIdRecipe(recipeDaoId.getId());
        recipeDto.setImageRecipe(recipeDaoId.getImageRecipe());
        recipeDto.setTitleRecipe(recipeDaoId.getTitleRecipe());
        recipeDto.setIdAuthorRecipe(recipeDaoId.getAuthorRecipe().getIdUser());
        recipeDto.setDescriptionRecipe(recipeDaoId.getDescriptionRecipe());
        recipeDto.setIdCategoryRecipe(recipeDaoId.getCategoryRecipe().getId());
        final List<RecipeListIngredientDto> ingredientWithRecipe = recipeDaoId.getWeightIngredients()
                .stream()
                .map(x -> new RecipeListIngredientDto(x.getIngredient().getId(),
                        x.getIngredient().getNameIngredientUkr(),
                        x.getWeightIngredient()))
                .collect(Collectors.toList());
        recipeDto.setIngredients(ingredientWithRecipe);
        recipeDto.setRating(recipeDaoId.getRating());
        return recipeDto;
    }

//    @Override
//    public Recipe getRecipe(int id) {
//        return recipeDao.findById(id).orElseThrow(() ->new RuntimeException());
    // }

    @Override
    public RecipeDto createRecipe(RecipeDto recipe) {
        List<WeightIngredient> weightIngredientsCreate = new ArrayList<>();
        Recipe recipeCreate = new Recipe();
        recipeCreate.setTitleRecipe(recipe.getTitleRecipe());
        recipeCreate.setImageRecipe(recipe.getImageRecipe());
        recipeCreate.setDescriptionRecipe(recipe.getDescriptionRecipe());
        recipeCreate.setRating(recipe.getRating());
        recipeCreate.setAuthorRecipe(userDao.findById(recipe.getIdAuthorRecipe()).get());
//        recipeCreate.setAuthorRecipe(userService.getUser(recipe.getIdAuthorRecipe()));
        recipeCreate.setCategoryRecipe(categoryRecipeDao.findById(recipe.getIdCategoryRecipe()).get());
//        recipeCreate.setCategoryRecipe(categoryRecipeService.getCategoryRecipe(recipe.getIdCategoryRecipe()));
        recipeCreate.setWeightIngredients(weightIngredientsCreate);
//        List<Ingredient> ingredintsCreate = new ArrayList<>();
        recipe.getIngredients()
                .stream()
                .forEach(x -> {
                    Ingredient ingredient = ingredientDao.findById(x.getIngredientId()).get();
//                    ingredintsCreate.add(ingredient);
                    WeightIngredient weightIngredient = new WeightIngredient(recipeCreate, ingredient, x.getWeightIngredient());
                    recipeCreate.getWeightIngredients().add(weightIngredient);
                });
//        recipeCreate.setIngredients(ingredintsCreate);
        recipeDao.save(recipeCreate);
        recipe.setIdRecipe(recipeCreate.getId());
        return recipe;
    }


    @Override
    public RecipeDto updateRecipe(int id, RecipeDto recipe) {
        if (!recipeDao.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No recipe found");
        }
        Recipe recipeUpdate = recipeDao.findById(id).get();
        recipeUpdate.getWeightIngredients().clear();
//        recipeUpdate.setId(id);
        recipeUpdate.setTitleRecipe(recipe.getTitleRecipe());
        recipeUpdate.setImageRecipe(recipe.getImageRecipe());
        recipeUpdate.setDescriptionRecipe(recipe.getDescriptionRecipe());
        recipeUpdate.setRating(recipe.getRating());
        recipeUpdate.setAuthorRecipe(userDao.findById(recipe.getIdAuthorRecipe()).get());
        recipeUpdate.setCategoryRecipe(categoryRecipeDao.findById(recipe.getIdCategoryRecipe()).get());
        recipe.getIngredients()
                .stream()
                .forEach(x -> {
                    Ingredient ingredient = ingredientDao.findById(x.getIngredientId()).get();
                    WeightIngredient weightIngredient = new WeightIngredient(recipeUpdate, ingredient, x.getWeightIngredient());
                    recipeUpdate.getWeightIngredients().add(weightIngredient);
                });
        recipeDao.saveAndFlush(recipeUpdate);
        recipe.setIdRecipe(id);
        return recipe;
    }

    @Override
    public void deleteRecipe(int id) {
        if (!recipeDao.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No recipe found");
        }
        recipeDao.deleteById(id);
    }
}
