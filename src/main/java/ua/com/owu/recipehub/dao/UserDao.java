package ua.com.owu.recipehub.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.com.owu.recipehub.models.User;

import java.util.List;

public interface UserDao extends JpaRepository <User, Integer> {
//   @Query("select d from User d join fetch d.recipes ")
//    List<User> myFindAllUser();
}
