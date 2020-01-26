package com.nsnieto.keepinmind.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class WordDto {

    @NotBlank
    private String nickName;

    @NotBlank
    private String name;

    @NotBlank
    private String mean;

}
