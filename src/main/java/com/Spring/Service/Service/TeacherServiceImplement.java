package com.Spring.Service.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.Spring.ManagementDao.TeacherDao;
import com.Spring.Service.ServiceImpleImp.TeacherService;
import com.Spring.model.Teacher;

@Service
@Transactional
public class TeacherServiceImplement implements TeacherService {

	private TeacherDao teacherdao;
	
	
	public TeacherServiceImplement(TeacherDao teacherdao) {
		super();
		this.teacherdao = teacherdao;
	}

	@Override
	public List<Teacher> allTeacher() {
		return teacherdao.getTeachers();
		
	}

	@Override
	public void deleteTeacher(int id) {
teacherdao.removeTeacher(id);		
	}

	@Override
	public void addTeacher(Teacher teacher) {
		teacherdao.addTeacher(teacher);
		
	}

	@Override
	public Teacher getTeacher(int id) {
		
		return teacherdao.getTeacher(id);
	}

}
