package com.Spring.ManagementDao;

import java.util.List;

import com.Spring.model.Student;


public interface StudentDao {

	

	public List<Student> getStudents();
	public void addStudent(Student student); 
	public void removeStudent(int id);
	public  Student getStudent(int id) ;

	
}
