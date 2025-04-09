package com.test.formbuilder.repository;

import com.test.formbuilder.entity.Form;
import com.test.formbuilder.entity.ResponseAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ResponseAnswerRepository extends JpaRepository<ResponseAnswer, String> {

	List<ResponseAnswer> findByResponseId(String id);

	List<ResponseAnswer> findByQuestionsId(String id);
	Optional<ResponseAnswer> findTopByOrderByIdDesc();
}
