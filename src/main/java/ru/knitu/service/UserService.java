package ru.knitu.service;

import ru.knitu.form.LoginForm;
import ru.knitu.form.SignUpForm;

public interface UserService {
    void saveUser(SignUpForm signUpForm);
}
