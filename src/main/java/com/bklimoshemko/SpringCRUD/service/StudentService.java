package com.bklimoshemko.SpringCRUD.service;

import com.bklimoshemko.SpringCRUD.entity.Student;
import com.bklimoshemko.SpringCRUD.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {
    private final StudentRepository repository;

    @Autowired
    private StudentService(final StudentRepository repository){
        this.repository = repository;
    }

    public Page<Student> getStudent(int pageNumber, int pageSize){
        return repository.findAll(PageRequest.of(pageNumber, pageSize));
    }

    public Optional<Student> getStudent(UUID id){
        return repository.findById(id);
    }

    public Student save(Student student){
        return repository.save(student);
    }

    public void delete (UUID id){
        repository.deleteById(id);
    }
}
