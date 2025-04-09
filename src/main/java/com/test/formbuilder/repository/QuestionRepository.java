package com.test.formbuilder.repository;

import com.test.formbuilder.entity.Form;
import com.test.formbuilder.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionRepository extends JpaRepository<Question, String> {
    List<Question> findByFormId(String formId);
    Optional<Question> findTopByOrderByIdDesc();
}
