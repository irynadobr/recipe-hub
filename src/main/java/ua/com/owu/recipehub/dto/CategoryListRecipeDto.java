package ua.com.owu.recipehub.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CategoryListRecipeDto {
    private int idCategoryRecipe;
    private String nameCategoryRecipe;
    private List<Integer> recipes;
}
