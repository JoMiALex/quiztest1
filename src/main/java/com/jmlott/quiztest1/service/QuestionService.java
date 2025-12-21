package com.jmlott.quiztest1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmlott.quiztest1.Question;
import com.jmlott.quiztest1.repository.QuestionRepository;

@Service
public class QuestionService {
    // Left off 17:05 in Tutorial

    @Autowired
    QuestionRepository questionRepository;

    public List<Question> getAllQuestions() {
        // Logic to get all questions from repository
        return questionRepository.findAll();
    }

    //Passes question object from controller call to repository to save to database
    public void addQuestion(Question question) {
        
    }

    public Optional<Question> getQuestionById(Integer id) {
        // TODO Auto-generated method stub
        return questionRepository.findById(id);
    }

    public List<Question> getQuestionsByCategory(String category) {
        // TODO Auto-generated method stub
        return questionRepository.findByCategory(category);
    }
}
