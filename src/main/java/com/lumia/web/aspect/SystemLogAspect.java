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
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
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
            LOG.info("前置通知");
        }
    }

    //环绕通知
    @Around("logAspect()&& @annotation(com.lumia.web.annotation.SystemLog)")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = null;
        try {
            LOG.info("环绕通知， 目标方法执行开始");
            long start = System.currentTimeMillis();
            result = joinPoint.proceed();
            System.out.println(result);
            long end = System.currentTimeMillis();
            LOG.info("环绕通知， 目标方法执行完成");
            LOG.info("耗时" + ((end - start) / 1000) + "s");
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
    private void addOperationLog(ProceedingJoinPoint joinPoint, Object res) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        SystemLog annotation = signature.getMethod().getAnnotation(SystemLog.class);

        if (annotation != null) {
                OperateLog operateLog = new OperateLog();
                String ip = request.getRemoteAddr();
                operateLog.setType(annotation.type());
                operateLog.setModule(annotation.module());
                operateLog.setDesc(annotation.desc());
                operateLog.setOperateTime(new Date());
                operateLog.setIp(ip);
                operateLogService.save(operateLog);
        }
        LOG.info("记录日志");
//        //获取目标类名
//        String targetName = joinPoint.getTarget().getClass().getName();
//        //获取方法名称
//        String methodName = joinPoint.getSignature().getName();
//        //获取相关参数
//        Object[] args = joinPoint.getArgs();
//        //生成类对象
//        Class targetClass = Class.forName(targetName);
//        //获取该类中的方法
//        Method[] methods = targetClass.getMethods();
//
//        for (Method method : methods) {
//            if (!method.getName().equals(methodName)) {
//                continue;
//            }
//            Class<?>[] parameterTypes = method.getParameterTypes();
//            //存在重载的情况
//            if (parameterTypes.length != args.length) {
//                continue;
//            }
//            SystemLog annotation = method.getAnnotation(SystemLog.class);
//            OperateLog operateLog = new OperateLog();
//            if (annotation != null) {
//                String ip = request.getRemoteAddr();
//                operateLog.setType(annotation.type());
//                operateLog.setModule(annotation.module());
//                operateLog.setDesc(annotation.desc());
//                operateLog.setOperateTime(new Date());
//                operateLog.setIp(ip);
//                operateLogService.save(operateLog);
//            }
//            LOG.info("记录日志" + annotation.desc());
//        }
    }

    //最终通知  final增强
    @After("logAspect()")
    public void doAfter(JoinPoint joinPoint){
        LOG.info("后置通知");
    }

}
