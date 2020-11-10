package com.example.dubbousersprovider.common;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * 检测方法执行耗时
 * @author zhixiaojie
 * @version 0.1
 */
@Aspect
@Component
@Slf4j
public class MethodTimeInterceptor {
    private static final long MAX_TIME = 100;
    private static final String POINT  =
            "( execution (* com.example.dubbousersprovider.controller..*.*(..)) || " +
                    "execution (* com.example.dubbousersprovider.service.impl..*.*(..)) || " +
                    "execution (* com.example.dubbousersprovider.client..*.*(..)) )";

    /**
     * 统计方法执行耗时Around环绕通知
     *
     * @param joinPoint ProceedingJoinPoint
     * @return Object
     */
    @Around(POINT)
    public Object timeAround(ProceedingJoinPoint joinPoint) throws Throwable {
        // 定义返回对象、得到方法需要的参数
        Object obj;
        Object[] args = joinPoint.getArgs();
        long startTime = System.currentTimeMillis();
        obj = joinPoint.proceed(args);
        // 获取执行的方法名
        long endTime = System.currentTimeMillis();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = signature.getDeclaringTypeName() + "." + signature.getName();
        // 打印耗时的信息
        this.printExecTime(methodName, startTime, endTime);
        return obj;
    }

    /**
     * 打印方法执行耗时的信息，如果超过了一定的时间，才打印
     *
     * @param methodName String
     * @param startTime long
     * @param endTime long
     */
    private void printExecTime(String methodName, long startTime, long endTime) {
        long diffTime = endTime - startTime;
        if (diffTime > MAX_TIME) {
            log.warn("-----" + methodName + " 方法执行耗时：" + diffTime + " ms");
        }
    }
}
