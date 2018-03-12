package bg.swift.ip.forum.entity;

import java.util.List;

public class User extends Entity {
    public static final String USER_KEY = "USER";
    private String name;
    private String email;
    private String password;
    private Gender gender;
    private int age;


    public User(String email, String name, String password, Gender gender, int age) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.age = age;
    }

    public User() {

    }


    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
