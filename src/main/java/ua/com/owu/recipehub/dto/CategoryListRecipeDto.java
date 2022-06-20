package ua.com.owu.recipehub.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CategoryListRecipeDto {
    private int id;
    private String category;
    List<Integer> recipes;

}
