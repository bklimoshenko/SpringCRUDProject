package com.bklimoshemko.SpringCRUD.repository;

import com.bklimoshemko.SpringCRUD.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static java.util.UUID.randomUUID;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository repository;

    @Test
    public void save_StoresRecord_WhenRecordIsValid() {

        final User expectedUser = new User();

        expectedUser.setUserName(randomUUID().toString());
        expectedUser.setPassword(randomUUID().toString());

        final User savedUser = repository.save(expectedUser);

        final User actualUser = entityManager.find(User.class, savedUser.getUserName());

        assertThat(actualUser).isEqualTo(expectedUser);
    }
}