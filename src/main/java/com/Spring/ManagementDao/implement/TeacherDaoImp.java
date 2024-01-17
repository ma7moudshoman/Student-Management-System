package com.Spring.ManagementDao.implement;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.Spring.Service.ServiceImpleImp.TeacherService;
import com.Spring.model.Teacher;


@Repository
public class TeacherDaoImp implements TeacherService {

	private SessionFactory sessionFactory;

	
	
	public TeacherDaoImp(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	

	@Override
	public List<Teacher> allTeacher() {
Session session = sessionFactory.getCurrentSession();
		
		Query<Teacher> query = session.createQuery("from Teacher",Teacher.class);
	
		return query.getResultList();
	}

	@Override
	public void deleteTeacher(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("delete from Teacher where id=?1");
		q.setInteger(1, id);
		
		q.executeUpdate();
	}

	@Override
	public void addTeacher(Teacher teacher) {
		  
		Session session = sessionFactory.getCurrentSession();
          session.saveOrUpdate(teacher);
	}


	@Override
	public Teacher getTeacher(int id) {
		
		Session session = sessionFactory.getCurrentSession();
        return session.get(Teacher.class,id);
	}

}
