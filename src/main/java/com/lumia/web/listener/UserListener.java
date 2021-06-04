package com.lumia.web.listener;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.lumia.web.entity.EventProperty;
import com.lumia.web.entity.EventUserDto;
import com.lumia.web.entity.UserProperty;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

public class UserListener extends AnalysisEventListener<UserProperty> {


    private List<EventUserDto> eventUserDtos = new ArrayList<>();

    private EventUserDto eventUserDto;

    @Override
    public void invoke(UserProperty userProperty, AnalysisContext analysisContext) {
        if (StrUtil.isNotBlank(userProperty.getDeviceId()) || StrUtil.isNotBlank(userProperty.getLoginId())) {
            //对象不为空则添加到集合中
            if (eventUserDto != null) {
                eventUserDtos.add(eventUserDto);
            }
            eventUserDto = new EventUserDto();
            eventUserDto.setDeviceId(userProperty.getDeviceId());
            eventUserDto.setLoginId(userProperty.getLoginId());
        }
        //解析属性
        parseProperty(eventUserDto, userProperty);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        eventUserDtos.add(eventUserDto);
    }

    public List<EventUserDto> getList() {
        return this.eventUserDtos;
    }

    //解析属性
    private EventUserDto parseProperty(EventUserDto eventUserDto, UserProperty userProperty) {
        String dataType = userProperty.getDataType();
        Object value;
        try {
            switch (dataType) {
                case "字符串":
                    value = userProperty.getAttributeValue();
                    break;
                case "数值":
                    value = NumberUtil.parseNumber(userProperty.getAttributeValue());
                    break;
                case "日期":
                    value = NumberUtil.parseLong(userProperty.getAttributeValue());
                    break;
                case "布尔":
                    value = new Boolean(userProperty.getAttributeValue());
                    break;
                case "集合":
                    value = Arrays.stream(userProperty.getAttributeValue().split(",")).collect(Collectors.toList());
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
            properties.put(userProperty.getAttributeName(), value);
            eventUserDto.setProperties(properties);
        }
        return eventUserDto;
    }

}
