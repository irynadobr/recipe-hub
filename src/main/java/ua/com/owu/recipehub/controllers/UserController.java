package ua.com.owu.recipehub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ua.com.owu.recipehub.dto.UserListRecipeDto;
import ua.com.owu.recipehub.models.Ingredient;
import ua.com.owu.recipehub.models.User;
import ua.com.owu.recipehub.service.IngredientService;
import ua.com.owu.recipehub.service.user.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "")
    public List<UserListRecipeDto> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(value = "/{id}")
    public User getByIdUser(@PathVariable int id){
        return userService.getUser(id);
    }


    @PostMapping(value = "")
    @ResponseStatus(HttpStatus.CREATED)
    public User insertUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public User updateUser(@PathVariable int id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }
}
