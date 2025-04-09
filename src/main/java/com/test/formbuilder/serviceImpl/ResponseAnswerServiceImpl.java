package com.test.formbuilder.serviceImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.formbuilder.conversion.CustomIdGeneratorServiceForm;
import com.test.formbuilder.conversion.CustomIdGeneratorServiceResponseAnswer;
import com.test.formbuilder.dto.ResponseAnswerDTO;
import com.test.formbuilder.dto.ResponseDTO;
import com.test.formbuilder.entity.Question;
import com.test.formbuilder.entity.QuestionOption;
import com.test.formbuilder.entity.Response;
import com.test.formbuilder.entity.ResponseAnswer;
import com.test.formbuilder.repository.QuestionOptionRepository;
import com.test.formbuilder.repository.QuestionRepository;
import com.test.formbuilder.repository.ResponseAnswerRepository;
import com.test.formbuilder.repository.ResponseRepository;
import com.test.formbuilder.service.ResponseAnswerService;

@Service
public class ResponseAnswerServiceImpl implements ResponseAnswerService {
	@Autowired
	ResponseAnswerRepository responseAnswerRepository;
	@Autowired
	ResponseRepository responseRepository;
	@Autowired 
	QuestionRepository questionRepository;
	@Autowired 
	QuestionOptionRepository questionOptionRepository;
	@Autowired 
	private ModelMapper modelMapper;
	@Autowired
	private CustomIdGeneratorServiceResponseAnswer customIdGeneratorService;
	@Override
	public ResponseAnswerDTO storeAnswers(ResponseAnswerDTO responseAnswerDTO, String respid, String quesid,
			String selectedoptid) {
		
		Response response=responseRepository.findById(respid).orElse(null);
		Question question=questionRepository.findById(quesid).orElse(null);
		QuestionOption questionOption=questionOptionRepository.findById(selectedoptid).orElse(null);
		
		ResponseAnswer responseAnswer=new ResponseAnswer();
		responseAnswer.setId(customIdGeneratorService.generateNextId());
		responseAnswer.setAnswerText(responseAnswerDTO.getAnswerText());
		responseAnswer.setResponse(response);
		responseAnswer.setQuestions(question);
		responseAnswer.setSelectedOption(questionOption);
		
		ResponseAnswer responseAnswers=responseAnswerRepository.save(responseAnswer);
		ResponseAnswerDTO responsesAnswerDTO =new ResponseAnswerDTO();
		responsesAnswerDTO.setId(responseAnswers.getId());
		responsesAnswerDTO.setAnswerText(responseAnswers.getAnswerText());
		responsesAnswerDTO.setResponseId(responseAnswers.getResponse().getId());
		responsesAnswerDTO.setQuestionId(responseAnswers.getQuestions().getId());
		responsesAnswerDTO.setSelectedOptionId(responseAnswers.getId());
		return responsesAnswerDTO;
		
 }
	@Override
	public List<ResponseAnswerDTO> fetchUsingResponseID(String id) {
		
		List<ResponseAnswer> responseAnswer= responseAnswerRepository.findByResponseId(id);
		ArrayList<ResponseAnswerDTO> updResponseAnswers=new ArrayList<ResponseAnswerDTO>();
		for(int i=0;i<responseAnswer.size();i++)
		{
			updResponseAnswers.add(new ResponseAnswerDTO(
					responseAnswer.get(i).getId(),
					responseAnswer.get(i).getAnswerText(),
					responseAnswer.get(i).getQuestions().getId(),
					responseAnswer.get(i).getSelectedOption().getId(),
					responseAnswer.get(i).getResponse().getId()
					));
		}
		return updResponseAnswers;
	}
	@Override
	public List<ResponseAnswerDTO> fetchUsingQuestionID(String id) {
		List<ResponseAnswer> responseAnswer= responseAnswerRepository.findByQuestionsId(id);
		ArrayList<ResponseAnswerDTO> updResponseAnswerDTO=new ArrayList<ResponseAnswerDTO>();
		for(int i=0;i<responseAnswer.size();i++)
		{
			updResponseAnswerDTO.add(new ResponseAnswerDTO(
					responseAnswer.get(i).getId(),
					responseAnswer.get(i).getAnswerText(),
					responseAnswer.get(i).getQuestions().getId(),
					responseAnswer.get(i).getSelectedOption().getId(),
					responseAnswer.get(i).getResponse().getId()
					));
		}
        return updResponseAnswerDTO;
	}
	

}
