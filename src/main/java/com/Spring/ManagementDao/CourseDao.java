package com.Spring.ManagementDao;

import java.util.List;

import com.Spring.model.Course;


public interface CourseDao {
	
	public  List<Course> getCourses() ;
   public void addCourse(Course course);
   public Course getCourse(int id);
   public void removeCourse(int id);
}
