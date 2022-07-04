package ua.com.owu.recipehub.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.com.owu.recipehub.models.ActivityTypeUser;
import ua.com.owu.recipehub.models.Recipe;
import ua.com.owu.recipehub.models.Sex;
import ua.com.owu.recipehub.models.User;

import javax.validation.constraints.Email;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserListRecipeDto {
    private int idUser;
    private String photoUser;
    private ActivityTypeUser activityTypeUser;
    private String nameUser;
    private String lastNameUser;
    private Sex sex;
    private List<Integer> recipes;

    public UserListRecipeDto (User user) {
        this.idUser=user.getIdUser();
        this.photoUser=user.getPhotoUser();
        this.activityTypeUser=user.getActivityTypeUser();
        this.nameUser=user.getNameUser();
        this.lastNameUser=user.getLastNameUser();
        this.sex=user.getSex();
        this.recipes=user.getRecipes().stream().map(Recipe::getId).collect(Collectors.toList());
    }
}
