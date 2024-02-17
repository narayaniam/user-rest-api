package org.utexas.enm.user.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.utexas.enm.user.restapi.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByUsername(String username);
}

