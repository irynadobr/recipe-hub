package ua.com.owu.recipehub.service.recipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.com.owu.recipehub.dao.RecipeDao;
import ua.com.owu.recipehub.models.Recipe;

import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService{
    @Autowired
    private RecipeDao recipeDao;

    @Override
    public List<Recipe> getALLRecipes() {
        return recipeDao.findAll();
    }

    @Override
    public Recipe getRecipe(int id) {
        return recipeDao.findById(id).orElseThrow(() ->new RuntimeException());
    }

    @Override
    public Recipe createRecipe(Recipe recipe) {
        return recipeDao.saveAndFlush(recipe);
    }


    @Override
    public Recipe updateRecipe(int id, Recipe recipe) {
        recipe.setId(id);
        if (!recipeDao.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No ingredient found");
        }
        return recipeDao.saveAndFlush(recipe);
    }
    @Override
    public void deleteRecipe(int id) {
        if (!recipeDao.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No ingredient found");
        }
        recipeDao.deleteById(id);
    }
}
