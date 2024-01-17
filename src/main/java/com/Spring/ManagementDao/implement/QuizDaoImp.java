package com.Spring.ManagementDao.implement;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.Spring.ManagementDao.QuizDao;
import com.Spring.Service.ServiceImpleImp.QuizService;
import com.Spring.model.Course;
import com.Spring.model.Quiz;


@Repository
public class QuizDaoImp implements QuizDao {

	 private SessionFactory sessionFactory;
	
	@Autowired
	public QuizDaoImp(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}


	@Override
	public List<Quiz> getQuizes() {
		Session session = sessionFactory.getCurrentSession();
		Query<Quiz> query=session.createQuery("from Quiz",Quiz.class);
		return query.getResultList();
	}


	@Override
	public void addQuiz(Quiz quiz) {
Session session = sessionFactory.getCurrentSession();
 session.saveOrUpdate(quiz);
	}


	@Override
	public Quiz getQuiz(int id) {
		Session session=sessionFactory.getCurrentSession();
		return session.get(Quiz.class, id);
	}


	@Override
	public void removeQuiz(int id) {
Session session=sessionFactory.getCurrentSession();
Query q =session.createQuery("delete from Quiz where id=?1");
q.setInteger(id,1);
q.executeUpdate();
	}
	
	





}
