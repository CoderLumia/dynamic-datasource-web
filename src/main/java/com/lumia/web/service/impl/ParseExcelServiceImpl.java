package com.lumia.web.service.impl;

import com.alibaba.excel.EasyExcel;
import com.lumia.web.entity.EventProperty;
import com.lumia.web.entity.EventUserDto;
import com.lumia.web.entity.ParseExcelDto;
import com.lumia.web.entity.UserProperty;
import com.lumia.web.listener.EventListener;
import com.lumia.web.listener.UserListener;
import com.lumia.web.service.ParseExcelService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class ParseExcelServiceImpl implements ParseExcelService {

    /** 解析excel */
    @Override
    public ParseExcelDto parseExcel(File excelFile) {
        if (!excelFile.exists()) {
            throw new RuntimeException("文件不存在");
        }
        String name = excelFile.getName();
        if (name.startsWith("event")) {
            EventListener eventListener = new EventListener();
            EasyExcel.read(excelFile, EventProperty.class, eventListener).build().read(EasyExcel.readSheet().build());

            List<EventUserDto> list = eventListener.getList();

            ParseExcelDto parseExcelDto = new ParseExcelDto();
            parseExcelDto.setIsEvent(true);
            parseExcelDto.setEventUserDtos(list);

            return parseExcelDto;
        } else if (name.startsWith("user")) {
            UserListener userListener = new UserListener();
            EasyExcel.read(excelFile, UserProperty.class, userListener).build().read(EasyExcel.readSheet().build());

            List<EventUserDto> list = userListener.getList();

            ParseExcelDto parseExcelDto = new ParseExcelDto();
            parseExcelDto.setIsEvent(false);
            parseExcelDto.setEventUserDtos(list);

            return parseExcelDto;
        } else {
            throw new RuntimeException("文件名不符合要求");
        }
    }
}
