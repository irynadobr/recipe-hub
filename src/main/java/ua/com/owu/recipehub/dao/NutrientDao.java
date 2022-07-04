package ua.com.owu.recipehub.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.owu.recipehub.models.Nutrient;


public interface NutrientDao extends JpaRepository <Nutrient, Integer> {
}
