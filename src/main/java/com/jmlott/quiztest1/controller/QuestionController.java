package com.jmlott.quiztest1.controller;
import com.jmlott.quiztest1.Question;
import com.jmlott.quiztest1.service.QuestionService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/questions")
public class QuestionController {
    
    @Autowired
    QuestionService questionService;
    
    @GetMapping("/allQuestions")
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
        //return "List of questions";
    }

    @GetMapping("/questionCount")
    public Integer getQuestionCount() {
        List<Question> questions = questionService.getAllQuestions();
        return questions.size();
    }
    

    //User POST to add a new question
    @PostMapping("/add")
    public String addQuestion(@RequestBody Question question) {
        // Call service to post new question object
        questionService.addQuestion(question);
        return "Question added successfully";
    }

}
