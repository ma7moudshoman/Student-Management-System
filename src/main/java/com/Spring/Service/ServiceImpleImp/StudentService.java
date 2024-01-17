package com.Spring.Service.ServiceImpleImp;

import java.util.List;

import com.Spring.model.Student;

public interface StudentService {
 
	
	public List<Student> allStudent();
    public void deleteStudent(int id);
    public void addStudent(Student student);
    public Student getStudent(int id);


}
