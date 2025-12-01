package com.jmlott.quiztest1.controller;
import com.jmlott.quiztest1.service.QuestionService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/questions")
public class QuestionController {
    
    @Autowired
    QuestionService questionService;
    
    @GetMapping("/allQuestions")
    public String getAllQuestions() {
        return questionService.getAllQuestions();
        //return "List of questions";
    }

}
