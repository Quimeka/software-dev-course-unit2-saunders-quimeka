package com.onyxreflections.dto.response;

public class UserResponseDTO {

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String theme;
    private String font;

    public UserResponseDTO() {
    }

    public UserResponseDTO(Integer id, String firstName, String lastName, String email, String theme, String font) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.theme = theme;
        this.font = font;
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
