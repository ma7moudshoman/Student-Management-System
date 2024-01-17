package com.Spring.ManagementDao.implement;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Spring.ManagementDao.CourseDao;
import com.Spring.model.Course;

@Repository 
public class CourseDaoImp implements CourseDao{

	 private SessionFactory sessionFactory;
	
	@Autowired
	public CourseDaoImp(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@Override
	public List<Course> getCourses() {
		Session session = sessionFactory.getCurrentSession();
		Query<Course> query=session.createQuery("from Course",Course.class);
		return query.getResultList();
	}


	@Override
	public void addCourse(Course course) {
		Session session = sessionFactory.getCurrentSession();
session.saveOrUpdate(course);
	}


	@Override
	public Course getCourse(int id) {
		Session session = sessionFactory.getCurrentSession();
	
		return session.get(Course.class,id);
	}
	


	@Override
	public void removeCourse(int id) {
		Session session = sessionFactory.getCurrentSession();
Query q = session.createQuery("delete from Course where id=?1");
q.setInteger(1, id);
q.executeUpdate();
	}
	

}
