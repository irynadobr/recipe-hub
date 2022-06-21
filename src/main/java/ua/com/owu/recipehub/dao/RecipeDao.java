package ua.com.owu.recipehub.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.owu.recipehub.models.Recipe;

public interface RecipeDao extends JpaRepository <Recipe, Integer> {


}
