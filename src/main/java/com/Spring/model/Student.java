package com.Spring.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int id;

    @Column(name = "name")
 private String name;

@Column(name = "age")
 private int age;

@Column(name = "email")
 private String Email;

@ManyToMany(mappedBy = "students")
 private List courses;
@ManyToOne
@JoinColumn(name = "teacher_id")
private Teacher teacher;
}

