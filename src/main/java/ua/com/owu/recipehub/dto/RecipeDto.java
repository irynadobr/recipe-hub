package ua.com.owu.recipehub.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class RecipeDto {
    private int id;
    private String image;
    private String title;
    private int authorId;
    private int categoryId;
    private List <Integer> ingredientId;
    private double rating;
}
