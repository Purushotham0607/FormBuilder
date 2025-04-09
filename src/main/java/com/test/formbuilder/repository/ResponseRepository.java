package com.test.formbuilder.repository;

import com.test.formbuilder.entity.Form;
import com.test.formbuilder.entity.Response;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ResponseRepository extends JpaRepository<Response, String> {

	List<Response> findByFormsId(String id);
	Optional<Response> findTopByOrderByIdDesc();
}
