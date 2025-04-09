package com.test.formbuilder.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.formbuilder.entity.Form;
import com.test.formbuilder.entity.QuestionOption;

@Repository
public interface QuestionOptionRepository extends JpaRepository<QuestionOption, String> {
	Optional<QuestionOption> findTopByOrderByIdDesc();
}
