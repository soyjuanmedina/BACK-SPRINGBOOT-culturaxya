package com_.onlineceremony.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com_.onlineceremony.mappers.QuestionMapper;
import com_.onlineceremony.models.QuestionEntity;
import com_.onlineceremony.payload.response.QuestionResponse;
import com_.onlineceremony.payload.response.QuestionsResponse;
import com_.onlineceremony.repository.QuestionRepository;

@Service
public class QuestionService {
	
	@Autowired 
	private QuestionRepository questionRepository;
	
	@Autowired 
	private QuestionMapper questionMapper;
	
	public List<QuestionResponse> getQuestionsByTheme(String theme, Integer number) {
		
		List<QuestionEntity> questionsEntities = questionRepository.findByTheme(theme);
		
		List<QuestionResponse> questionsResponse = questionMapper.map(questionsEntities);
		
		return getRamdomsOfList(questionsResponse, number);
	}
	
	private List<QuestionResponse> getRamdomsOfList (List<QuestionResponse> questionsEntities, Integer number) {
		List<QuestionResponse> randomList = new ArrayList();
		
		Random random = new Random();;

		for (int i = 0; i < number; i++) {
			int index = random.nextInt(questionsEntities.size());
			
			QuestionResponse randomQuestion = questionsEntities.get(index);
			
			while (randomList.contains(randomQuestion)) {
				index = random.nextInt(questionsEntities.size());
				randomQuestion = questionsEntities.get(index);
	        }
	
			randomList.add(randomQuestion);
			
	      }
		
		return randomList;
	}

}
