package com_.onlineceremony.payload.response;

import java.util.List;
import java.util.Set;

import com_.onlineceremony.models.QuestionEntity;
import lombok.Data;

@Data
public class QuestionsResponse {

	private List<QuestionResponse> questions;

}
