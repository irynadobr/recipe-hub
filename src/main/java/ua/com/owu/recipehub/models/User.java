package ua.com.owu.recipehub.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String login;
    private String password;
    private String photo;
    private String email;
    private int weight;
    private int height;
    private int age;
    private String gender;
    private String activityType;
    private String name;
    private String lastName;
    private String dateOfRegistration;

}
