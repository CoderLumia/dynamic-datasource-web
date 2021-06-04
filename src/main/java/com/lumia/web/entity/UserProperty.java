package com.lumia.web.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class UserProperty {

    @ExcelProperty(index = 0)
    private String deviceId;

    @ExcelProperty(index = 1)
    private String loginId;

    @ExcelProperty(index = 2)
    private String attributeName;

    @ExcelProperty(index = 3)
    private String attributeValue;

    @ExcelProperty(index = 4)
    private String dataType;
}
