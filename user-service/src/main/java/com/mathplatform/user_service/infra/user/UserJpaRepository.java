package com.mathplatform.user_service.infra.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserJpaRepository extends JpaRepository<UserTable, UUID> {

    Optional<UserTable> findByEmail(String email);
}
