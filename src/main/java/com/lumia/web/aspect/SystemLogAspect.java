package com.lumia.web.aspect;

import com.lumia.web.annotation.SystemLog;
import com.lumia.web.entity.OperateLog;
import com.lumia.web.service.OperateLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class SystemLogAspect {

    private Logger LOG = LoggerFactory.getLogger(SystemLogAspect.class);

    private LocalVariableTableParameterNameDiscoverer parameterNameDiscoverer = new LocalVariableTableParameterNameDiscoverer();

    @Autowired
    private OperateLogService operateLogService;


    //切面
    @Pointcut("@annotation(com.lumia.web.annotation.SystemLog)")
    public void logAspect() {}


    //前置通知
    @Before("logAspect()")
    public void doBefore(JoinPoint joinPoint){
        if (LOG.isInfoEnabled()) {
            LOG.info("before" +joinPoint);
        }
    }

    //环绕通知
    @Around("logAspect()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = null;
        try {
            result = joinPoint.proceed();
            LOG.info("around" + joinPoint);
            return result;
        } finally {
            try {
                addOperationLog(joinPoint, result);
            } catch (Throwable throwable) {
                LOG.error(throwable.getMessage(), throwable);
            }
        }
    }

    //添加操作日志
    private void addOperationLog(JoinPoint joinPoint, Object res) {
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        OperateLog operateLog = new OperateLog();
        SystemLog annotation = signature.getMethod().getAnnotation(SystemLog.class);
        if (annotation != null) {
            operateLog.setType(annotation.type());
            operateLog.setModule(annotation.module());
            operateLog.setDesc(annotation.desc());
            operateLog.setOperateTime(new Date());
        }
        LOG.info("记录日志" + annotation.desc());
        operateLogService.save(operateLog);
    }

    //最终通知  final增强
    @After("logAspect()")
    public void doAfter(JoinPoint joinPoint){
        LOG.info("后置通知");
    }

}
