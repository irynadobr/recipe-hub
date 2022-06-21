package ua.com.owu.recipehub.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.com.owu.recipehub.dto.CategoryListRecipeDto;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String category;
    @OneToMany (targetEntity =Recipe.class)
    @JoinColumn(name = "category_id")
    @JsonIgnore
    private List <Recipe> recipes;

}
