package ua.com.owu.recipehub.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.owu.recipehub.models.Recipe;

public interface RecipeDao extends JpaRepository <Recipe, Integer> {
}
