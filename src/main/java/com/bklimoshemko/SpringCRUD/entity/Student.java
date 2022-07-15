package com.bklimoshemko.SpringCRUD.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="student")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "s_id")
    private UUID id;
    @Column(name = "s_fist_name")
    private String firstName;
    @Column(name = "s_last_name")
    private String lastName;


}
