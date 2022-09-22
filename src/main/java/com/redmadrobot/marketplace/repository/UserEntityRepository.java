package com.redmadrobot.marketplace.repository;

import com.redmadrobot.marketplace.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {

    @Query("SELECT * FROM UserEntity u WHERE u.email = ?1")
    UserEntity findByEmail(String email);
}
