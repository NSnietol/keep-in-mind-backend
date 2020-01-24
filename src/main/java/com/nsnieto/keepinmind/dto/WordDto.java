package com.nsnieto.keepinmind.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class WordDto {

	
	
	@NotBlank
	private String nickName;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String mean;
	
	
}
