package com.lumia.web.service.impl;

import com.lumia.web.service.AnnotationService;
import org.springframework.stereotype.Component;

@Component
public class AnnotationServiceProd implements AnnotationService {
    @Override
    public String sayHello() {
        return "Prod";
    }
}
