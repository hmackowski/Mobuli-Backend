package com.mobuli.repository;

import com.mobuli.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserName(String userName);
    Optional<User> findByEmailAddress(String emailAddress);
    Boolean existsByEmailAddress(String emailAddress);
    Boolean existsByUserName(String Username);

    //Users findByUserNameOrEmailAdress(String usernameOrEmailAdress);
}
