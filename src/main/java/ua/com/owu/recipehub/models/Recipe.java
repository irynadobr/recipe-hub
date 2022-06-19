package ua.com.owu.recipehub.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
   private double rating;
}
