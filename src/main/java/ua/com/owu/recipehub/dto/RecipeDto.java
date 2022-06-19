package ua.com.owu.recipehub.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class RecipeDto {
    private int id;
    private String image;
    private String title;
    private int authorId;
    private int categoryId;
    private double rating;


}
