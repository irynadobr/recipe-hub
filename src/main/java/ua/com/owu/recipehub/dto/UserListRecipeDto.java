package ua.com.owu.recipehub.dto;

import lombok.*;
import ua.com.owu.recipehub.models.ActivityTypeUser;
import ua.com.owu.recipehub.models.Recipe;
import ua.com.owu.recipehub.models.Sex;
import ua.com.owu.recipehub.models.User;

import javax.validation.constraints.Email;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserListRecipeDto {
    private int idUser;
    private String loginUser;
    private String passwordUser;
    private String photoUser;
    private String emailUser;
    private int weightUser;
    private int heightUser;
    private int ageUser;
    private Sex sex;
    private ActivityTypeUser activityTypeUser;
    private String nameUser;
    private String lastNameUser;
    private String dateOfRegistrationUser;
    private List<Integer> recipes;

    public UserListRecipeDto(User user) {
        this.idUser = user.getIdUser();

        this.photoUser = user.getPhotoUser();
        this.activityTypeUser = user.getActivityTypeUser();
        this.nameUser = user.getNameUser();
        this.lastNameUser = user.getLastNameUser();
        this.sex = user.getSex();
        this.recipes = user.getRecipes().stream().map(Recipe::getId).collect(Collectors.toList());
    }

    public UserListRecipeDto(int idUser,String loginUser, String passwordUser,
                             String photoUser, String emailUser, int weightUser,
                             int heightUser,int ageUser, Sex sex, ActivityTypeUser activityTypeUser,
                             String nameUser, String lastNameUser, String dateOfRegistrationUser) {
        this.idUser = idUser;
        this.loginUser=loginUser;
        this.passwordUser=passwordUser;
        this.photoUser = photoUser;
        this.emailUser=emailUser;
        this.weightUser=weightUser;
        this.heightUser=heightUser;
        this.sex = sex;
        this.activityTypeUser = activityTypeUser;
        this.nameUser = nameUser;
        this.lastNameUser=lastNameUser;
        this.dateOfRegistrationUser=dateOfRegistrationUser;
    }
}
