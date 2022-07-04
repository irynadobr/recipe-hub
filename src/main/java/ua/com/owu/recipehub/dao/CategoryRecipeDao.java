package ua.com.owu.recipehub.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.owu.recipehub.models.CategoryRecipe;

public interface CategoryRecipeDao extends JpaRepository <CategoryRecipe, Integer> {
//@Query("select d from CategoryRecipe d join fetch d.recipes")
//    List<CategoryRecipe> myFindAll();



}
