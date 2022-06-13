package ua.com.owu.recipehub.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.owu.recipehub.models.User;

public interface UserDao extends JpaRepository <User, Integer> {
}
