package ua.com.owu.recipehub.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String login;
    private String password;
    private String photo;
    private String email;
    private int weight;
    private int height;
    private int age;
    private Sex sex;
    private ActivityType activityType;
    private String name;
    private String lastName;
    private String dateOfRegistration;
    @OneToMany(targetEntity = Recipe.class)
    @JoinColumn(name = "author_id")
    @JsonIgnore
    private List<Recipe> recipes;

}
