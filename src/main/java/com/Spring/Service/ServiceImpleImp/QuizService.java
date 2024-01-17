package com.Spring.Service.ServiceImpleImp;

import java.util.List;

import com.Spring.model.Quiz;

public interface QuizService{
    public List<Quiz> allQuiz();
    public void deleteQuiz(int id);
    public void addQuiz(Quiz quiz);
    public Quiz getQuiz(int id);
}
