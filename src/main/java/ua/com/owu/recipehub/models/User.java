package ua.com.owu.recipehub.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import ua.com.owu.recipehub.dto.UserListRecipeDto;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;
    private String loginUser;
    private String passwordUser;
//    @Lob
//    private Byte [] photoUser;тип в таблиці blob
    private String photoUser;
    private String emailUser;
    private int weightUser;
    private int heightUser;
    private int ageUser;
    @Enumerated(EnumType.STRING)
    private Sex sex;
    @NotNull
    @Enumerated(EnumType.STRING)
    private ActivityTypeUser activityTypeUser;
    private String nameUser;
    private String lastNameUser;
//    @JsonFormat(pattern = "dd-MM-yyyy")
//    private LocalDate dateOfRegistrationUser;

private String dateOfRegistrationUser;
    @OneToMany(targetEntity = Recipe.class)
    @JoinColumn(name = "author_recipe_id_user")
    @JsonIgnore
    private List<Recipe> recipes;

public User(UserListRecipeDto userListRecipeDto) {
    this.idUser=userListRecipeDto.getIdUser();



}

}
