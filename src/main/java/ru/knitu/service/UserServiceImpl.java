package ru.knitu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.knitu.form.LoginForm;
import ru.knitu.form.SignUpForm;
import ru.knitu.model.Role;
import ru.knitu.model.State;
import ru.knitu.model.User;
import ru.knitu.repository.UsersRepository;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UsersRepository usersRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public void saveUser(SignUpForm signUpForm) {
        String hashpassword = passwordEncoder.encode(signUpForm.getPassword());
        User user = User.builder()
                .firstname(signUpForm.getFirstname())
                .lastname(signUpForm.getLastname())
                .login(signUpForm.getLogin())
                .password(hashpassword)
                .role(Role.USER)
                .state(State.ACTIVE)
                .build();
        usersRepository.save(user);
    }
}
