package com.jmlott.quiztest1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jmlott.quiztest1.Question;
import com.jmlott.quiztest1.repository.QuestionRepository;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    public ResponseEntity<List<Question>> getAllQuestions() {
        // Logic to get all questions from repository
        return new ResponseEntity<>(questionRepository.findAll(), HttpStatus.OK);
    }

    //Passes question object from controller call to repository to save to database
    public String addQuestion(Question question) {
        questionRepository.save(question);
        return "Question added successfully";
    }

    public String updateQuestion(Integer id, Question question) {
    Optional<Question> existingQuestion = questionRepository.findById(id);
    
    if (existingQuestion.isPresent()) {
        Question q = existingQuestion.get();
        // Update only the fields you want changed
        if (question.getQuestionTitle() != null) q.setQuestionTitle(question.getQuestionTitle());
        if (question.getOption1() != null) q.setOption1(question.getOption1());
        if (question.getOption2() != null) q.setOption2(question.getOption2());
        if (question.getOption3() != null) q.setOption3(question.getOption3());
        if (question.getOption4() != null) q.setOption4(question.getOption4());
        if (question.getCorrectAnswer() != null) q.setCorrectAnswer(question.getCorrectAnswer());
        if (question.getCategory() != null) q.setCategory(question.getCategory());
        if (question.getDifficultyLevel() != null) q.setDifficultyLevel(question.getDifficultyLevel());
        
        questionRepository.save(q);
        return "Question with ID " + id + " updated successfully";
    }
    return "Question with ID " + id + " not found";
    }

    public Optional<Question> getQuestionById(Integer id) {
        return questionRepository.findById(id);
    }

    public List<Question> getQuestionsByCategory(String category) {
        return questionRepository.findByCategory(category);
    }

    public List<Question> getQuestionByDifficulty(String difficulty) {
        return questionRepository.findByDifficultyLevel(difficulty);
    }
    
    public String deleteQuestionById(Integer id) {
        questionRepository.deleteById(id);
        return "Question with ID " + id + " deleted successfully.";
    }

}