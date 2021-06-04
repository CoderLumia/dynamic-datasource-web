package com.lumia.web.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class EventProperty {

    @ExcelProperty(index = 0)
    private String eventName;

    @ExcelProperty(index = 1)
    private String deviceId;

    @ExcelProperty(index = 2)
    private String loginId;

    @ExcelProperty(index = 3)
    private String attributeName;

    @ExcelProperty(index = 4)
    private String attributeValue;

    @ExcelProperty(index = 5)
    private String dataType;
}
