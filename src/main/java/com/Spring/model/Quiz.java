package com.Spring.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Quiz {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
@Column(name = "title")

    private String title;
@ManyToMany
        (mappedBy = "Quiz_student")
private List<Student>students;

}

