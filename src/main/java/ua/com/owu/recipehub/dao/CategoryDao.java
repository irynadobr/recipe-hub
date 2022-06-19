package ua.com.owu.recipehub.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.owu.recipehub.models.Category;

public interface CategoryDao extends JpaRepository <Category, Integer> {
}
