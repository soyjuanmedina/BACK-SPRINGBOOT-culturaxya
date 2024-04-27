package com_.onlineceremony.controllers;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com_.onlineceremony.models.QuestionEntity;
import com_.onlineceremony.payload.request.LoginRequest;
import com_.onlineceremony.payload.request.QuestionsRequest;
import com_.onlineceremony.payload.response.JwtResponse;
import com_.onlineceremony.payload.response.QuestionsResponse;
import com_.onlineceremony.payload.response.QuestionResponse;
import com_.onlineceremony.security.services.UserDetailsImpl;
import com_.onlineceremony.services.QuestionService;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/questions")
public class QuestionController {
	
	@Autowired 
	private QuestionService questionService;
	
	@GetMapping("/getAll")
	public ResponseEntity<QuestionsResponse> getQuestions(@Valid @RequestParam String theme, 
			@Valid @RequestParam Integer number) {

		List<QuestionResponse> questions = questionService.getQuestionsByTheme(theme, number);
		
		QuestionsResponse response = new QuestionsResponse();
	    response.setQuestions(questions);
	     
	     return new ResponseEntity<>(response, HttpStatus.OK);
		
	}

}
