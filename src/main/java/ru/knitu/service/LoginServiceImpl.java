package ru.knitu.service;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.knitu.form.LoginForm;
import ru.knitu.model.Token;
import ru.knitu.model.User;
import ru.knitu.repository.TokensRepository;
import ru.knitu.repository.UsersRepository;
import ru.knitu.transfer.TokenDto;

import java.util.Optional;
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    TokensRepository tokensRepository;
    @Autowired
    UsersRepository usersRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public TokenDto loginUser(LoginForm loginForm) {
        Optional<User> userCandidate = usersRepository.findUserByLogin(loginForm.getLogin());
        if(userCandidate.isPresent()){
            User user = userCandidate.get();
            if(passwordEncoder.matches(loginForm.getPassword(),user.getPassword())){
                Token token = Token.builder()
                        .value(RandomStringUtils.random(7,true,true))
                        .user(user)
                        .build();
                tokensRepository.save(token);
                return TokenDto.from(token);
            }
        }  throw new IllegalArgumentException("User not found_");
    }
}
