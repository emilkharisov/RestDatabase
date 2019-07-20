package ru.knitu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.knitu.form.SignUpForm;
import ru.knitu.repository.UsersRepository;
import ru.knitu.service.UserService;


@RestController
public class SignUpController {
    @Autowired
    UsersRepository usersRepository;
    @Autowired
    UserService userService;

    @PostMapping("/signUp")
    public ResponseEntity<Object> addUser(@RequestBody SignUpForm signUpForm)
    {
        userService.saveUser(signUpForm);
        usersRepository.findAll();
        return ResponseEntity.ok().build();
    }
}
