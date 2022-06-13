package ua.com.owu.recipehub.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.owu.recipehub.models.Ingredient;

public interface IngredientDao extends JpaRepository <Ingredient, Integer> {

}
