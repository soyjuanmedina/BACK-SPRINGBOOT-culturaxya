package com_.onlineceremony.payload.response;

import java.util.List;

import lombok.Data;

@Data
public class QuestionResponse {
	
	private String question;
	
	private List<AnswerResponse> answers;
	
	private String explanation;

}
