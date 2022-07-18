package com.bklimoshemko.SpringCRUD.service;


import com.bklimoshemko.SpringCRUD.entity.User;
import com.bklimoshemko.SpringCRUD.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;



@Service
public class UserService {
    private final UserRepository repository;

    @Autowired
    public UserService(final UserRepository repository){
        this.repository = repository;
    }
}
