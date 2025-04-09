package com.test.formbuilder.repository;

import com.test.formbuilder.entity.Form;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormRepository extends JpaRepository<Form, String> {
	Optional<Form> findTopByOrderByIdDesc();
}
