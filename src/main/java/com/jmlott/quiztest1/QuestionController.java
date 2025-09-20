package com.jmlott.quiztest1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/questions")
public class QuestionController {
    
    
    @GetMapping("/allQuestions")
    public String getAllQuestions() {
        return "List of questions";
    }

}
