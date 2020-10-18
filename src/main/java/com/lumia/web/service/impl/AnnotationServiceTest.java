package com.lumia.web.service.impl;

import com.lumia.web.service.AnnotationService;
import org.springframework.stereotype.Component;

@Component
public class AnnotationServiceTest implements AnnotationService {

    @Override
    public String sayHello() {
        return "Test";
    }
}
