package com.lumia.web.listener;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.NumberUtil;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.lumia.web.entity.EventProperty;
import com.lumia.web.entity.EventUserDto;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

public class EventListener extends AnalysisEventListener<EventProperty> {


    private List<EventUserDto> eventUserDtos = new ArrayList<>();

    private EventUserDto eventUserDto;

    @Override
    public void invoke(EventProperty eventProperty, AnalysisContext analysisContext) {
        int size = analysisContext.readRowHolder().getCellMap().size();
        if (StringUtils.isNoneBlank(eventProperty.getEventName())) {
            //对象不为空则添加到集合中
            if (eventUserDto != null) {
                eventUserDtos.add(eventUserDto);
            }
            eventUserDto = new EventUserDto();
            eventUserDto.setEventName(eventProperty.getEventName());
            eventUserDto.setDeviceId(eventProperty.getDeviceId());
            eventUserDto.setLoginId(eventProperty.getLoginId());
        }
        //解析属性
        parseProperty(eventUserDto, eventProperty);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        //添加最后一行
        eventUserDtos.add(eventUserDto);
    }

    public List<EventUserDto> getList() {
        return this.eventUserDtos;
    }

    //解析属性
    private EventUserDto parseProperty(EventUserDto eventUserDto, EventProperty eventProperty) {
        String dataType = eventProperty.getDataType();
        Object value;
        try {
            switch (dataType) {
                case "字符串":
                    value = eventProperty.getAttributeValue();
                    break;
                case "数值":
                    value = NumberUtil.parseNumber(eventProperty.getAttributeValue());
                    break;
                case "日期":
                    value = NumberUtil.parseLong(eventProperty.getAttributeValue());
                    break;
                case "布尔":
                    value = new Boolean(eventProperty.getAttributeValue());
                    break;
                case "集合":
                    value = Arrays.stream(eventProperty.getAttributeValue().split(",")).collect(Collectors.toList());
                    break;
                default:
                    value = null;
            }
        } catch (Throwable throwable) {
            value = null;
        }
        if (value != null) {
            Map<String, Object> properties = eventUserDto.getProperties();
            if (CollUtil.isEmpty(properties)) {
                properties = new HashMap<>();
            }
            properties.put(eventProperty.getAttributeName(), value);
            eventUserDto.setProperties(properties);
        }
        return eventUserDto;
    }

}
