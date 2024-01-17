package com.Spring.ManagementDao;

import java.util.List;

import com.Spring.model.Teacher;


public interface TeacherDao {

	
	public List<Teacher> getTeachers();
	public void addTeacher(Teacher teacher); 
	public void removeTeacher(int id);
	public  Teacher getTeacher(int id) ;

	
	
}


