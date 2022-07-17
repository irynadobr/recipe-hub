package ua.com.owu.recipehub.service.user;

import ua.com.owu.recipehub.dto.UserListRecipeDto;

import java.util.List;

public interface UserService {
    List<UserListRecipeDto> getAllUsers();

//    User getUser(int id);

    UserListRecipeDto createUser(UserListRecipeDto user);

    void deleteUser(int id);

    UserListRecipeDto updateUser(int id, UserListRecipeDto user);


    UserListRecipeDto getUser(int id);
}
