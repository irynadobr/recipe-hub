package ua.com.owu.recipehub.service.user;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.com.owu.recipehub.dao.UserDao;
import ua.com.owu.recipehub.dto.UserListRecipeDto;
import ua.com.owu.recipehub.models.Ingredient;
import ua.com.owu.recipehub.models.Recipe;
import ua.com.owu.recipehub.models.User;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


//    @Override
//    public List<UserListRecipeDto> getAllUsers() {
//        return userDao.findAll();
//    }


    @Override
    public List<UserListRecipeDto> getAllUsers() {
        final List<User> userDaoAll = userDao.findAll();
        final List<UserListRecipeDto> collect = userDaoAll.stream()
                .map(user -> {
                    UserListRecipeDto userListRecipeDto = new UserListRecipeDto();
                    userListRecipeDto.setIdUser(user.getIdUser());
                    userListRecipeDto.setLoginUser(user.getLoginUser());
                    userListRecipeDto.setPasswordUser(user.getPasswordUser());
                    userListRecipeDto.setPhotoUser(user.getPhotoUser());
                    userListRecipeDto.setEmailUser(user.getEmailUser());
                    userListRecipeDto.setWeightUser(user.getWeightUser());
                    userListRecipeDto.setHeightUser(user.getHeightUser());
                    userListRecipeDto.setAgeUser(user.getAgeUser());
                    userListRecipeDto.setActivityTypeUser(user.getActivityTypeUser());
                    userListRecipeDto.setNameUser(user.getNameUser());
                    userListRecipeDto.setLastNameUser(user.getLastNameUser());
                    userListRecipeDto.setSex(user.getSex());
                    userListRecipeDto.setDateOfRegistrationUser(user.getDateOfRegistrationUser());
                    final List<Integer> idRecipe = user.getRecipes().stream()
                            .map(Recipe::getId)
                            .collect(Collectors.toList());
                    userListRecipeDto.setRecipes(idRecipe);
                    return userListRecipeDto;
                }).collect(Collectors.toList());
        return collect;
    }

    @Override
    public UserListRecipeDto getUser(int id) {
        final User userDaoId = userDao.findById(id)
                .orElseThrow(() -> new RuntimeException());
        UserListRecipeDto userListRecipeDto = new UserListRecipeDto();
        userListRecipeDto.setIdUser(userDaoId.getIdUser());
        userListRecipeDto.setLoginUser(userDaoId.getLoginUser());
        userListRecipeDto.setPasswordUser(userDaoId.getPasswordUser());
        userListRecipeDto.setPhotoUser(userDaoId.getPhotoUser());
        userListRecipeDto.setEmailUser(userDaoId.getEmailUser());
        userListRecipeDto.setWeightUser(userDaoId.getWeightUser());
        userListRecipeDto.setHeightUser(userDaoId.getHeightUser());
        userListRecipeDto.setAgeUser(userDaoId.getAgeUser());
        userListRecipeDto.setActivityTypeUser(userDaoId.getActivityTypeUser());
        userListRecipeDto.setNameUser(userDaoId.getNameUser());
        userListRecipeDto.setLastNameUser(userDaoId.getLastNameUser());
        userListRecipeDto.setSex(userDaoId.getSex());
        userListRecipeDto.setDateOfRegistrationUser(userDaoId.getDateOfRegistrationUser());
        final List<Integer> idRecipe = userDaoId.getRecipes().stream()
                .map(Recipe::getId)
                .collect(Collectors.toList());
        userListRecipeDto.setRecipes(idRecipe);
        return userListRecipeDto;
    }


//    @Override
//    public User getUser(int id) {
//
//        return userDao.findById(id).orElseThrow(() ->new RuntimeException());
//    }


//    @Override
//    public UserListRecipeDto getUser(int id) {
//
//
//        return userDao.findById(id).orElseThrow(() ->new RuntimeException());
//    }

    @Override
    public UserListRecipeDto createUser(UserListRecipeDto user) {
        User userCreate = new User();
        userCreate.setLoginUser(user.getLoginUser());
        userCreate.setPasswordUser(user.getPasswordUser());
        userCreate.setPhotoUser(user.getPhotoUser());
        userCreate.setEmailUser(user.getEmailUser());
        userCreate.setWeightUser(user.getWeightUser());
        userCreate.setHeightUser(user.getHeightUser());
        userCreate.setAgeUser(user.getAgeUser());
        userCreate.setSex(user.getSex());
        userCreate.setActivityTypeUser(user.getActivityTypeUser());
        userCreate.setNameUser(user.getNameUser());
        userCreate.setLastNameUser(user.getLastNameUser());
        userCreate.setDateOfRegistrationUser(user.getDateOfRegistrationUser());
        userDao.saveAndFlush(userCreate);
        user.setIdUser(userCreate.getIdUser());
        return user;
    }

    @Override
    public UserListRecipeDto updateUser(int id, UserListRecipeDto user) {
        if (!userDao.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No ingredient found");
        }
        User userUpdate = userDao.findById(id).get();
        userUpdate.setLoginUser(user.getLoginUser());
        userUpdate.setPasswordUser(user.getPasswordUser());
        userUpdate.setPhotoUser(user.getPhotoUser());
        userUpdate.setEmailUser(user.getEmailUser());
        userUpdate.setWeightUser(user.getWeightUser());
        userUpdate.setHeightUser(user.getHeightUser());
        userUpdate.setAgeUser(user.getAgeUser());
        userUpdate.setSex(user.getSex());
        userUpdate.setActivityTypeUser(user.getActivityTypeUser());
        userUpdate.setNameUser(user.getNameUser());
        userUpdate.setLastNameUser(user.getLastNameUser());
        userUpdate.setDateOfRegistrationUser(user.getDateOfRegistrationUser());
        userDao.saveAndFlush(userUpdate);
        user.setIdUser(id);
        return user;
    }

    @Override
    public void deleteUser(int id) {
        if (!userDao.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No user found");
        }
        userDao.deleteById(id);
    }

}
