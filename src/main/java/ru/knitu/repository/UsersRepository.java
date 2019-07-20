package ru.knitu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.knitu.model.User;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User,Integer> {
    Optional<User> findUserByLogin(String login);
    User findUserById(int id);
}
