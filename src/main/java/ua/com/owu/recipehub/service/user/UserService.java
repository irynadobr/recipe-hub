package ua.com.owu.recipehub.service.user;

import ua.com.owu.recipehub.models.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUser(int id);

    User createUser(User user);

    void deleteUser(int id);

    User updateUser(int id, User user);


}
