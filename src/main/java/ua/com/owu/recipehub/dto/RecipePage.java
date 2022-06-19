package ua.com.owu.recipehub.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.com.owu.recipehub.models.Recipe;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RecipePage {
    private List<Recipe> recipes;
    private int totalPage;
    private long totalElements;
    private int currentPage;
    private boolean last;
}
