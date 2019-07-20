package ru.knitu.form;

import lombok.Data;

@Data
public class SignUpForm {
    private String firstname;
    private String lastname;
    private String login;
    private String password;
}
