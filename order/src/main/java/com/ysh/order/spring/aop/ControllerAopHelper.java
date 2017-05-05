package com.ysh.order.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ControllerAopHelper {

	@Pointcut("execution(* com.ysh.order.controller..*.*(..))")
	public void executeService() {

	}

	/**
	 * 后置最终通知（目标方法只要执行完了就会执行后置通知方法）
	 * 
	 * @param joinPoint
	 */
	@After("executeService()")
	public void doAfterAdvice(JoinPoint joinPoint) {
		System.out.println("后置通知执行了!!!!");
	}

	/**
	 * 前置通知（目标方法只要执行前就会执行前置通知方法）
	 * 
	 * @param joinPoint
	 */
	@Before("executeService()")
	public void doBeforeAdvice(JoinPoint joinPoint) {
		// 获取目标方法的参数信息
		Object[] obj = joinPoint.getArgs();
		System.out.println("obj is:" + obj);
		// AOP代理类的信息
		joinPoint.getThis();
		// 代理的目标对象
		joinPoint.getTarget();
		// 用的最多 通知的签名
		Signature signature = joinPoint.getSignature();
		// 代理的是哪一个方法
		System.out.println(signature.getName());
		// AOP代理类的名字
		System.out.println(signature.getDeclaringTypeName());
		// AOP代理类的类（class）信息
		signature.getDeclaringType();
		System.out.println("前置通知执行了!!!!");
	}

}
