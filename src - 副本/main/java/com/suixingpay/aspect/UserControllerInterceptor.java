
package com.suixingpay.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;



import org.springframework.util.StringUtils;


@Aspect // import org.aspectj.lang.annotation.Aspect;
@Component
public class UserControllerInterceptor {
//    private static final Logger logger = LoggerFactory.getLogger(UserControllerInterceptor.class);
//     
//
//    
//
//    /**
//     * 定义拦截规则org.suixingpay.controller @RequestMapping注解的方法
//     */
//    @Pointcut("execution(* org.suixingpay.controller..*(..)) and @annotation(org.springframework.web.bind.annotation.RequestMapping)")
//    public void controllerMethodPointcut() {
//    }
//
//    /**
//     * 拦截器的具体实现
//     *
//     * @param pjp
//     * @throws Throwable 
//     */
//    @Around("controllerMethodPointcut()") // 指定拦截器规则 可以直接把“execution(*
//                                          // com.suixingpay.........)”写到这里
//    public Object Interceptor(ProceedingJoinPoint joinPoint) throws Throwable {
//        return joinPoint.proceed(); 
//        
//    }
}

