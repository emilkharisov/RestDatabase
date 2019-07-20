package ru.knitu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.knitu.model.User;
import ru.knitu.repository.UsersRepository;

import java.util.List;

@RestController
public class UsersController {
    @Autowired
    UsersRepository usersRepository;

    @GetMapping("/users")
    public List<User> getUsers(){
        return  usersRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable int id){
        return  usersRepository.findUserById(id);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id){
        usersRepository.delete(usersRepository.findUserById(id));
    }
}
