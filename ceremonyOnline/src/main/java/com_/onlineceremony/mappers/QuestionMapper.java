package com_.onlineceremony.mappers;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import com_.onlineceremony.models.QuestionEntity;
import com_.onlineceremony.payload.response.AnswerResponse;
import com_.onlineceremony.payload.response.QuestionResponse;

@Mapper(componentModel = "spring")
public interface QuestionMapper {
	
	List<QuestionResponse> map(List<QuestionEntity> questionsEntity);
	
	@Mapping(target="question", source="question")
    @Mapping(target="explanation", source="explanation")
	@Mapping(source = "source", target = "answers", qualifiedByName = "getAnswerList")
	QuestionResponse entitytoResponse(QuestionEntity source);
	
	@Named("getAnswerList")
	default List<AnswerResponse> getAnswerList(QuestionEntity source) {
		List<AnswerResponse> answers = new ArrayList();
		AnswerResponse correctAnswer = new AnswerResponse();
		correctAnswer.setAnswer(source.getCorrect_answer());
		correctAnswer.setIsCorret(true);
		answers.add(correctAnswer);
		
		AnswerResponse other_answer_1 = new AnswerResponse();
		other_answer_1.setAnswer(source.getOther_answer_1());
		other_answer_1.setIsCorret(false);
		answers.add(other_answer_1);
		
		AnswerResponse other_answer_2 = new AnswerResponse();
		other_answer_2.setAnswer(source.getOther_answer_2());
		other_answer_2.setIsCorret(false);
		answers.add(other_answer_2);
		
		AnswerResponse other_answer_3 = new AnswerResponse();
		other_answer_3.setAnswer(source.getOther_answer_3());
		other_answer_3.setIsCorret(false);
		answers.add(other_answer_3);
		
		return answers;
		
	}
	

}
