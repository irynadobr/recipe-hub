package ua.com.owu.recipehub.dto;

import lombok.*;
import ua.com.owu.recipehub.models.Recipe;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RecipePage {
    private List<RecipeDto> recipes;
    private int totalPage;
    private long totalElements;
    private int currentPage;
    private boolean last;
}
