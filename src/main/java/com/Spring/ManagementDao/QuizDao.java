package com.Spring.ManagementDao;

import java.util.List;


import com.Spring.model.Quiz;

public interface QuizDao {


	public List<Quiz> getQuizes();
	public void addQuiz(Quiz quiz); 
	public void removeQuiz(int id);
	public  Quiz getQuiz(int id) ;



	
}
