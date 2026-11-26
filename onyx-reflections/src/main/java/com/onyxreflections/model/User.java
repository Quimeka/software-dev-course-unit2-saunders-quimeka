package com.onyxreflections.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;



@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "First name required")
    private String firstName;

    @NotBlank(message = "Last name required")
    private String lastName;

    @Column(unique = true)
    @NotBlank(message = "Email required")
    private String email;

    @NotBlank(message = "Password required")
    private String password;

    private String theme;

    private String font;

    //theme is selected for the user and font is selected for the new user.
    public User() {
        this.theme = "default";
        this.font = "Georgia";
    }

    //theme is selected for the user and font is selected for the new user.
    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.theme = "default";
        this.font = "Georgia";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getFont() {
        return font;
    }

    public void setFont(String font) {
        this.font = font;
    }
}
