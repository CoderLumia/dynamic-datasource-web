package com.lumia.web.service.impl;

import com.lumia.web.entity.OperateLog;
import com.lumia.web.mapper.OperateLogMapper;
import com.lumia.web.service.OperateLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperateLogServiceImpl implements OperateLogService {

    @Autowired
    private OperateLogMapper operateLogMapper;

    @Override
    public int save(OperateLog operateLog) {
        return operateLogMapper.save(operateLog);
    }
}
