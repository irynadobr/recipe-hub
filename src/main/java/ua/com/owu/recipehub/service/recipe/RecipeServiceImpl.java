package ua.com.owu.recipehub.service.recipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.com.owu.recipehub.dao.RecipeDao;
import ua.com.owu.recipehub.dto.RecipeDto;
import ua.com.owu.recipehub.dto.RecipePage;
import ua.com.owu.recipehub.models.Recipe;
import ua.com.owu.recipehub.service.category.CategoryService;
import ua.com.owu.recipehub.service.user.UserService;

import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService{
    @Autowired
    private RecipeDao recipeDao;

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private UserService userService;


//    @Override
//    public List<Recipe> getALLRecipes() {
//        return recipeDao.findAll();
//    }
@Override
public RecipePage getALLRecipes(int page, int size) {
  final Page<Recipe> recipes = recipeDao.findAll( PageRequest.of(page, size)) ;
  final RecipePage recipePage = new RecipePage();
 recipePage.setRecipes(recipes.getContent());
 recipePage.setCurrentPage(recipes.getNumber());
 recipePage.setLast(recipes.isLast());
    recipePage.setTotalPage(recipes.getTotalPages());
 recipePage.setTotalElements(recipes.getTotalElements());
     return recipePage;
}

    @Override
    public Recipe getRecipe(int id) {
        return recipeDao.findById(id).orElseThrow(() ->new RuntimeException());
    }

//    @Override
//    public RecipeDto createRecipe(RecipeDto recipe) {
//        return recipeDao.saveAndFlush(recipe);
//    }

    @Override
    public RecipeDto createRecipe(RecipeDto recipe) {
        Recipe recipeDB = new Recipe();
        recipeDB.setTitle(recipe.getTitle());
        recipeDB.setImage(recipe.getImage());
        recipeDB.setCategory(categoryService.getCategory(recipe.getCategoryId()));
        recipeDB.setAuthor(userService.getUser(recipe.getAuthorId()));
        recipeDB.setRating(recipe.getRating());
        recipeDao.saveAndFlush(recipeDB);
        recipe.setId(recipeDB.getId());

        return recipe;
    }

    @Override
    public Recipe updateRecipe(int id, Recipe recipe) {
        recipe.setId(id);
        if (!recipeDao.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No recipe found");
        }
        return recipeDao.saveAndFlush(recipe);
    }
    @Override
    public void deleteRecipe(int id) {
        if (!recipeDao.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No recipe found");
        }
        recipeDao.deleteById(id);
    }
}
