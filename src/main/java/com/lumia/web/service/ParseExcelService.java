package com.lumia.web.service;


import com.lumia.web.entity.ParseExcelDto;

import java.io.File;

public interface ParseExcelService {


    ParseExcelDto parseExcel(File excelFile);

}
