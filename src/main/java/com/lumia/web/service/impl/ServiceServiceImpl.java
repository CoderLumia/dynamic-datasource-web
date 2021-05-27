package com.lumia.web.service.impl;

import com.lumia.web.mapper.ServiceMapper;
import com.lumia.web.service.ServiceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ServiceServiceImpl implements ServiceService {

    @Resource
    private ServiceMapper serviceMapper;

    @Override
    public String getService() {
        return serviceMapper.getService();
    }
}
