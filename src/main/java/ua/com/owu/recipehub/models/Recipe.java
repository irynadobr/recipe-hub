package ua.com.owu.recipehub.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String image;
    private String title;
    @ManyToOne(targetEntity = User.class)
    @JsonIgnore
    private User author;
    private String description;
    @ManyToOne(targetEntity = Category.class)
    @JsonIgnore
    private Category category;
    @ManyToMany(targetEntity = Ingredient.class)
    @JoinTable(name = "recipeIngredient",joinColumns = @JoinColumn(name = "recipe_id"),inverseJoinColumns = @JoinColumn(name="ingredient_id"))
    @JsonIgnore
    private List<Ingredient> ingredients;
    private double rating;
}
