package ua.com.owu.recipehub.models;

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
    private String description;
    private String category;
    @OneToOne
    @JoinColumn(name = "author_id")
    private User author;
   private double rating;
}
