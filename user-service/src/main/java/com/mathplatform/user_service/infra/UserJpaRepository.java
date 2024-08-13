package com.mathplatform.user_service.infra;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserJpaRepository extends JpaRepository<UserTable, UUID> {
}
