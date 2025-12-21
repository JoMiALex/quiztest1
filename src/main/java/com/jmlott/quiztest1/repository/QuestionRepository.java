package com.jmlott.quiztest1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jmlott.quiztest1.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

    // Custom query methods can be defined here
    List<Question> findByCategory(String category);
    
}
