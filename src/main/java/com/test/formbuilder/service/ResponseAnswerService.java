package com.test.formbuilder.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.test.formbuilder.dto.ResponseAnswerDTO;

@Service
public interface ResponseAnswerService {

	public ResponseAnswerDTO storeAnswers(ResponseAnswerDTO responseAnswerDTO, String respid, String quesid, String selectedoptid);

	public List<ResponseAnswerDTO> fetchUsingResponseID(String id);

	public List<ResponseAnswerDTO> fetchUsingQuestionID(String id);

}
