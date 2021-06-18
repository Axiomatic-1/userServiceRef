package com.andersonmicroserviseslesson.userservices.repository;

import com.andersonmicroserviseslesson.userservices.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserId(Long userId);
}
