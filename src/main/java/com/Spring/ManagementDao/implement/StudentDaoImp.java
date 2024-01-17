package com.Spring.ManagementDao.implement;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Spring.Service.ServiceImpleImp.StudentService;
import com.Spring.model.Student;



@Repository
public class StudentDaoImp implements StudentService  {

	private SessionFactory sessionFactory;
 
	
	@Autowired
	public StudentDaoImp(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Student> allStudent() {
Session session = sessionFactory.getCurrentSession();
		
		Query<Student> query = session.createQuery("from Student",Student.class);
		
		return query.getResultList();
	}

	@Override
	public void addStudent(Student student) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(student);
	}

	@Override
	public Student getStudent(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Student.class,id);
	}

	@Override
	public void deleteStudent(int id) {
		Session session = sessionFactory.getCurrentSession();

		Query q = session.createQuery("delete from Student where id=?1");
		q.setInteger(1, id);
		
		q.executeUpdate();
	}

}
