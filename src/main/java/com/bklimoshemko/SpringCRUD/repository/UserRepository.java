package com.bklimoshemko.SpringCRUD.repository;

import com.bklimoshemko.SpringCRUD.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
