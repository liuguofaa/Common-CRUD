package com.company.aop;

import com.company.common.utils.FastJson;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author guofa.liu
 * @create 2018/11/26 17:46
 * @description 监控所有Controller执行情况(注意所有接口都要规范)
 */

//TODO 记录用户操作记录

//@Component
//@Aspect
@Slf4j
public class ControllerAspect {

    @Pointcut("execution(public * com.company.controller.*.*(..))")
    public void pointcut() {
    }


    @Around("pointcut()")
    public Object arround(ProceedingJoinPoint pjp) throws Throwable {
        //获取request
        HttpServletRequest request = getRequest();
        //请求前获取参数
        String uri = request.getRequestURI();
        String method = request.getMethod();
        log.info("请求地址：{} {}", method, uri);
        Map<String, String[]> parameterMap = request.getParameterMap();
        log.info("请求参数：" + FastJson.toJSONString(parameterMap));
        //执行
        Object result = pjp.proceed();
        //获取响应结果
        log.info("响应结果：" + FastJson.toJSONString(result));
        return result;
    }

    private HttpServletRequest getRequest(){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        return request;
    }

    private HttpServletResponse getResponse(){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = requestAttributes.getResponse();
        return response;
    }
}