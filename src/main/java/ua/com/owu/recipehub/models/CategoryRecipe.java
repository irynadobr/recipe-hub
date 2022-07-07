package ua.com.owu.recipehub.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
public class CategoryRecipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String nameCategoryRecipe;
    @OneToMany(targetEntity = Recipe.class)
    @JoinColumn(name = "category_recipe_id")
    @JsonIgnore
    private List<Recipe> recipes;

}
