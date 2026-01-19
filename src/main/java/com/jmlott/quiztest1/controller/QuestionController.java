package com.jmlott.quiztest1.controller;
import com.jmlott.quiztest1.Question;
import com.jmlott.quiztest1.service.QuestionService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        return questionService.addQuestion(question);
    }

    @GetMapping("/{id}")
    public Optional<Question> getQuestionById(@PathVariable Integer id) {
        return questionService.getQuestionById(id);
    }

    @GetMapping("category/{category}")
    public List<Question> getQuestionsByCategory(@PathVariable String category) {
        return questionService.getQuestionsByCategory(category);
    }

    @GetMapping("difficulty/{difficulty}")
    public List<Question> getMethodName(@PathVariable String difficulty) {
        return questionService.getQuestionByDifficulty(difficulty);
    }

    //Function to delete question by id
    @DeleteMapping("/delete/{id}")
    public String deleteQuestionById(@PathVariable Integer id) {
        return questionService.deleteQuestionById(id);
    }
    
    
    //Left off at 34:00 in Tutorial

}
