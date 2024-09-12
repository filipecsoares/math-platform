package com.mathplatform.user_service.infra.user;

import com.mathplatform.user_service.application.UserRepository;
import com.mathplatform.user_service.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final UserJpaRepository userJpaRepository;

    public UserRepositoryImpl(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    @Override
    public User save(User user) {
        userJpaRepository.save(UserTable.fromDomain(user));
        return user;
    }

    @Override
    public User findByEmail(String email) {
        var userTable = userJpaRepository.findByEmail(email);
        return userTable.map(UserTable::toDomain).orElseThrow(() -> new RuntimeException("User not found"));
    }
}
