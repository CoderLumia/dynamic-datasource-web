package com.lumia.web.entity;

import lombok.Data;

import java.util.List;

@Data
public class ParseExcelDto {

    private Boolean isEvent = true;

    private List<EventUserDto> eventUserDtos;
}
