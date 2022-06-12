package ua.com.owu.recipehub.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.com.owu.recipehub.dao.IngredientDao;
import ua.com.owu.recipehub.models.Ingredient;

import java.util.List;
@Service
public class IngredientServiceImpl implements IngredientService{
  @Autowired
   private  IngredientDao ingredientDao;
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

    @Override
    public List<Ingredient> getAllIngredient() {
        return ingredientDao.findAll();
    }

    @Override
    public void deleteIngredient(int id) {
        if (!ingredientDao.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No ingredient found");
        }
        ingredientDao.deleteById(id);
    }
}
