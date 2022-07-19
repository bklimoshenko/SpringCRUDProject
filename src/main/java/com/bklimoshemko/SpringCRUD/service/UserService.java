package com.bklimoshemko.SpringCRUD.service;


import com.bklimoshemko.SpringCRUD.entity.User;
import com.bklimoshemko.SpringCRUD.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;


@Service
public class UserService implements UserDetailsService {
    private final UserRepository repository;

    @Autowired
    public UserService(final UserRepository repository){
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        final Optional<User> record = repository.findByUserName(username);

        if (record.isEmpty()){
            throw new UsernameNotFoundException("User with name: " + username + " is not found");
        }

        final User user = record.get();

        return new org.springframework.security.core.userdetails.User(
                user.getUserName(),
                user.getPassword(),
                Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")) );
    }

    public User save(final User user) {
        return repository.save(user);
    }
}
