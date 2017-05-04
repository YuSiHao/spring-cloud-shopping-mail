package com.ysh.order.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ControllerAopHelper {

	@Pointcut("execution(* com.ysh.order.controller..*.*(..))")
    public void executeService(){

    }
	
}
