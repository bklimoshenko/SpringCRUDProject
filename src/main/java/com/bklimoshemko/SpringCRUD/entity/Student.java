package com.bklimoshemko.SpringCRUD.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
    private int UUDI;
    private String firstName;
    private String lastName;


}
