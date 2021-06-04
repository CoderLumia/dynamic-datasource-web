package com.lumia.web.entity;

import lombok.Data;

import java.util.Map;

@Data
public class EventUserDto {

    private String eventName;

    private String deviceId;

    private String loginId;

    private Map<String, Object> properties;
}
