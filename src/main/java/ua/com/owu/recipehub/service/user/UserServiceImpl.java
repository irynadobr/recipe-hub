package ua.com.owu.recipehub.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.com.owu.recipehub.dao.UserDao;
import ua.com.owu.recipehub.dto.UserListRecipeDto;
import ua.com.owu.recipehub.models.Recipe;
import ua.com.owu.recipehub.models.User;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;


//    @Override
//    public List<UserListRecipeDto> getAllUsers() {
//        return userDao.findAll();
//    }


    @Override
    public List<UserListRecipeDto> getAllUsers() {
        final List<User>userDaoAll =userDao.findAll();
        final List<UserListRecipeDto> collect = userDaoAll.stream()
                .map(user -> {
                    UserListRecipeDto userListRecipeDto  = new UserListRecipeDto();
                    userListRecipeDto.setId(user.getId());
                    userListRecipeDto.setPhoto(user.getPhoto());
                    userListRecipeDto.setActivityType(user.getActivityType());
                    userListRecipeDto.setName(user.getName());
                    userListRecipeDto.setLastName(user.getLastName());
                    userListRecipeDto.setSex(user.getSex());

                    final List<Integer> idRecipe = user.getRecipes().stream()
                            .map(Recipe::getId)
                            .collect(Collectors.toList());
                    userListRecipeDto.setRecipes(idRecipe);
                    return userListRecipeDto;
                }).collect(Collectors.toList());
        return collect;
    }

    @Override
    public User getUser(int id) {
        return userDao.findById(id).orElseThrow(() ->new RuntimeException());
    }

    @Override
    public User createUser(User user) {

        return userDao.saveAndFlush(user);
    }

    @Override
    public void deleteUser(int id) {
        if (!userDao.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No user found");
        }
        userDao.deleteById(id);
    }

    @Override
    public User updateUser(int id, User user) {
        user.setId(id);
        if (!userDao.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No ingredient found");
        }
        return userDao.saveAndFlush(user);
    }
}
