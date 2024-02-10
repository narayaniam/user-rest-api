package org.utexas.enm.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.utexas.enm.restapi.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByUsername(String username);
}

