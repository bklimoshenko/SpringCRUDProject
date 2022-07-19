package com.bklimoshemko.SpringCRUD.repository;

import com.bklimoshemko.SpringCRUD.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findByUserName(final String username);
}
