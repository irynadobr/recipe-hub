package ua.com.owu.recipehub.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import ua.com.owu.recipehub.dto.CategoryListRecipeDto;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
public class CategoryRecipe  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    @NotBlank
    private String nameCategoryRecipe;
    @OneToMany(targetEntity = Recipe.class)
    @JoinColumn(name = "category_recipe_id")
    @JsonIgnore
    private List<Recipe> recipes;

}
