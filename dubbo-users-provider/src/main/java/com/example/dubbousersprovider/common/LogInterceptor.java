package com.example.dubbousersprovider.common;

import com.alibaba.fastjson.JSONObject;

import com.example.dubboapi.request.HttpResult;
import com.example.dubboapi.utils.ResponseJson;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * @author zhixiaojie
 * @Date 2019/7/10 18:06
 */
@Aspect
@Component
@Slf4j
public class LogInterceptor {

    private static final String POINT = "execution (* com.example.dubbousersprovider.controller..*.*(..))";

    @Pointcut(POINT)
    public void controllerMethod() {
    }


    @Before("controllerMethod()")
    public void logRequestInfo(JoinPoint joinPoint) throws Exception {

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        StringBuilder requestLog = new StringBuilder();
        requestLog.append("请求信息：")
                .append("HTTP_METHOD = {")
                .append(request.getMethod())
                .append("},\t")
                .append("CLASS_METHOD = {")
                .append(joinPoint.getSignature().getDeclaringTypeName())
                .append(".")
                .append(joinPoint.getSignature().getName())
                .append("},\t");

        if (joinPoint.getArgs().length == 0) {
            requestLog.append("ARGS = {} ");
        } else {
            if (joinPoint.getArgs()[0] instanceof HttpServletRequest || joinPoint.getArgs()[0] instanceof ServletResponse
                    || joinPoint.getArgs()[0] instanceof MultipartFile) {
                return;
            }
            requestLog.append("ARGS = ")
                    .append(new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL)
                            .writeValueAsString(joinPoint.getArgs()[0]));
        }

        log.info(requestLog.toString());
    }

    @AfterReturning(returning = "httpResult", pointcut = "controllerMethod()")
    public void logHttpResultInfo(HttpResult httpResult) {
        log.info(" 请求结果信息：" + JSONObject.toJSONString(httpResult));
    }

    @AfterReturning(returning = "responseJson", pointcut = "controllerMethod()")
    public void logResultVoInfo(ResponseJson responseJson) {
        String resultLog = "请求结果头信息：" + JSONObject.toJSONString(responseJson.getHeads()) +
                " 请求结果正文信息：" + JSONObject.toJSONString(responseJson.getBody());
        log.info(resultLog);
    }

}
