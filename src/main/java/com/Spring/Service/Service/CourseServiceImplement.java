package com.Spring.Service.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.Spring.ManagementDao.CourseDao;
import com.Spring.Service.ServiceImpleImp.CourseService;
import com.Spring.model.Course;


@Service
public class CourseServiceImplement implements CourseService {

	private CourseDao coursedao;
	
	
	
	public CourseServiceImplement(CourseDao coursedao) {
		super();
		this.coursedao = coursedao;
	}

	@Override
	@Transactional
	public List<Course> allCourses() {
		return coursedao.getCourses();
	}

	@Override
	public void deleteCourse(int id) {
		coursedao.removeCourse(id);
		
	}

	@Override
	public void addCourse(Course course) {

     coursedao.addCourse(course);
	}

	@Override
	public Course getCourse(int id) {
	return coursedao.getCourse(id);
	
	}



}