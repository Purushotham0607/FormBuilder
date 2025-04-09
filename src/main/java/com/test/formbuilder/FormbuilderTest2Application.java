package com.test.formbuilder;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FormbuilderTest2Application {

	public static void main(String[] args) {
		SpringApplication.run(FormbuilderTest2Application.class, args);
	}
	@Bean
    public ModelMapper modelMapper()
    {
	    return new ModelMapper();
    	
    }
}
