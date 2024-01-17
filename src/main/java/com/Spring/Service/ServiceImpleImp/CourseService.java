package com.Spring.Service.ServiceImpleImp;

import java.util.List;

import com.Spring.model.Course;

public interface CourseService {
	
	
    public List<Course>allCourses();
    public void deleteCourse(int id);
    public void addCourse(Course course);
    public Course getCourse(int id);


}
