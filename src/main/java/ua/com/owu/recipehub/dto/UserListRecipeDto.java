package ua.com.owu.recipehub.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.com.owu.recipehub.models.ActivityType;
import ua.com.owu.recipehub.models.Sex;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserListRecipeDto {
    private int id;
    private String photo;
    private ActivityType activityType;
    private String name;
    private String lastName;
    private Sex sex;
    private List<Integer> recipes;
}
