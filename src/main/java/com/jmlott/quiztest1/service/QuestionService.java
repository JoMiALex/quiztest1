package com.jmlott.quiztest1.service;

import java.util.List;

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
    }
}
