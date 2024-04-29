package com.mobuli.DAO;

import com.mobuli.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByUserName(String userName);
    Optional<Users> findByEmailAddress(String emailAddress);
    Boolean existsByEmailAddress(String emailAddress);

    //Users findByUserNameOrEmailAdress(String usernameOrEmailAdress);
}
