package com.bklimoshemko.SpringCRUD.service;

import com.bklimoshemko.SpringCRUD.entity.Student;
import com.bklimoshemko.SpringCRUD.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.BDDAssumptions.given;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
public class StudentServiceTest {

    @MockBean
    private StudentRepository repository;

    private StudentService fixture;

//    @BeforeEach
//    public void setUp(){
//        fixture = new StudentService(repository);
//    }

    @Test
    public void getStudent_ReturnsStudent_WhenStudentExists(){
        final UUID id = UUID.randomUUID();

        final Student student = new Student(UUID.randomUUID(), UUID.randomUUID().toString(), UUID.randomUUID().toString());

        final Optional<Student> expectedStudent = Optional.of(student);
    }

}