package ua.com.owu.recipehub.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.com.owu.recipehub.models.Category;

import java.util.List;

public interface CategoryDao extends JpaRepository <Category, Integer> {
@Query("select d from Category d join fetch d.recipes")
    List<Category> myFindAll();



}
