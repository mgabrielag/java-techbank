package com.techbank.techbank.repositories;

import com.techbank.techbank.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByEmail(String email);
    Optional<User> findUserByDocument(String document);
}
