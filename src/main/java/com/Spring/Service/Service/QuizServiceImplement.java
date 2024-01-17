package com.Spring.Service.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Spring.ManagementDao.QuizDao;
import com.Spring.Service.ServiceImpleImp.QuizService;
import com.Spring.model.Quiz;

@Service
public class QuizServiceImplement implements QuizService {

	@Autowired
    private QuizDao quizdao; 
    
    
public QuizServiceImplement () {
}
    
    @Override
    @Transactional
    public List<Quiz> allQuiz() {
        return quizdao.getQuizes();
    }

    @Override
    @Transactional
    public void deleteQuiz(int id) {
    quizdao.removeQuiz(id);
    }

	@Override
	public void addQuiz(Quiz quiz) {
		quizdao.addQuiz(quiz);
	}

	@Override
	public Quiz getQuiz(int id) {
		return quizdao.getQuiz(id);
	}

  
}
