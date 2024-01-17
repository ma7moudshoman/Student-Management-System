package com.Spring.Service.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.Spring.ManagementDao.StudentDao;
import com.Spring.Service.ServiceImpleImp.StudentService;
import com.Spring.model.Student;



public class StudentServiceImplement implements StudentService {
    @Autowired
    private StudentDao studentdao;

    public StudentServiceImplement(){

    }

    @Override
    public List<Student> allStudent() {
    return studentdao.getStudents();
    }

    @Override
    public void deleteStudent(int id) {

    	studentdao.removeStudent(id);
    }


    @Override
    public Student getStudent(int id) {
        return studentdao.getStudent(id);
    }

	@Override
	public void addStudent(Student student) {
studentdao.addStudent(student);		
	}

	
}
