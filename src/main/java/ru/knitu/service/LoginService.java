package ru.knitu.service;

import ru.knitu.form.LoginForm;
import ru.knitu.transfer.TokenDto;

public interface LoginService {
    TokenDto loginUser(LoginForm loginForm);
}
