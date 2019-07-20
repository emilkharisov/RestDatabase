package ru.knitu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.knitu.model.Token;

import java.util.Optional;

public interface TokensRepository extends JpaRepository<Token,Integer> {
    Optional<Token> findTokenByValue(String value);
}
