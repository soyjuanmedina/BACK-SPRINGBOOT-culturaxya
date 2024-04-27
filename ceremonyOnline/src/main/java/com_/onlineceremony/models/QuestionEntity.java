package com_.onlineceremony.models;

import javax.validation.constraints.NotBlank;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "questions")
public class QuestionEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotBlank
	private String theme;
	
	@NotBlank
	private String question;
	
	@NotBlank
	private String correct_answer;
	
	@NotBlank
	private String other_answer_1;
	
	@NotBlank
	private String other_answer_2;
	
	@NotBlank
	private String other_answer_3;
	
	@NotBlank
	private String explanation;
	
	
}
