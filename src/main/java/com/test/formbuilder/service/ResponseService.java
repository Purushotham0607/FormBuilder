package com.test.formbuilder.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.test.formbuilder.dto.ResponseDTO;

@Service
public interface ResponseService {

	public ResponseDTO createResponse(ResponseDTO responseDTO,String id);
    public List<ResponseDTO> listResponse(String id);
}
