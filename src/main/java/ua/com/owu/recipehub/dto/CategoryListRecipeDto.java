package ua.com.owu.recipehub.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.com.owu.recipehub.models.Category;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CategoryListRecipeDto  {
    private int idCategory;
    private String category;
    private List<Integer> recipes;
}
