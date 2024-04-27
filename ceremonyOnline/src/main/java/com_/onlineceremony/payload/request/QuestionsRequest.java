package com_.onlineceremony.payload.request;

import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class QuestionsRequest {
	private String theme;

	private Integer number;
}
