package com.Spring.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Teacher {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

@Column(name = "name")
 private String name;

 @Column(name = "email")
    private String email;
@OneToMany(mappedBy = "Teacher_student")
 private List<Student>students;

@OneToMany(mappedBy = "quiz_Tea")
private List<Quiz>quizzes;


}
