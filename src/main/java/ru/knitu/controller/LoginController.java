package ru.knitu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.knitu.form.LoginForm;
import ru.knitu.service.LoginService;

@RestController
public class LoginController {
    @Autowired
    LoginService loginService;

    @PostMapping("/login")
    public void loginUser(@RequestBody LoginForm loginForm){
        loginService.loginUser(loginForm);
    }
}
