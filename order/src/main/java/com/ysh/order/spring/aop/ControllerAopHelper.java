package com.ysh.order.spring.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ControllerAopHelper {

	@Pointcut("execution(* com.ysh.order.controller.TestController.testAop(..))")
	public void executeService() {

	}

	@Pointcut(value = "execution(* com.ysh.order.controller.TestController.testAopParam(..)) && args(name)", argNames = "name")
	public void executeService1(String name) {

	}

	@Before(value = "executeService1(name)")
	public void doBeforeAdvice1(String name) {
		System.out.println("前置通知执行了!!!!");
		System.out.println("前置name is:" + name);
	}

	/*
	 * @AfterThrowing(value = "executeService1(name)", throwing = "exception")
	 * public void doAfterThrowingAdvice(JoinPoint joinPoint, Throwable
	 * exception) { // 目标方法名：
	 * System.out.println(joinPoint.getSignature().getName()); if (exception
	 * instanceof NullPointerException) { System.out.println("发生了空指针异常!!!!!"); }
	 * }
	 */

	@After(value = "executeService1(name)")
	public void doAfterAdvice1(String name) {
		System.out.println("返回name is:" + name);
		System.out.println("后置通知执行了!!!!");
	}

	/**
	 * 后置最终通知（目标方法只要执行完了就会执行后置通知方法）
	 * 
	 * @param joinPoint
	 */
	@AfterReturning(value = "executeService()", returning = "returnValue")
	public void doAfterAdvice(String returnValue) {

		System.out.println("after result:" + returnValue);
		System.out.println("后置通知执行了!!!!");
	}

	/**
	 * 前置通知（目标方法只要执行前就会执行前置通知方法）
	 * 
	 * @param joinPoint
	 */
	@Before("executeService() && " + "args(t,..)")
	public void doBeforeAdvice(String t) {
		System.out.println("before t:" + t);
		// 获取目标方法的参数信息
		/*
		 * Object[] obj = joinPoint.getArgs(); System.out.println("obj is:" +
		 * obj); // AOP代理类的信息 joinPoint.getThis(); // 代理的目标对象
		 * joinPoint.getTarget(); // 用的最多 通知的签名 Signature signature =
		 * joinPoint.getSignature(); // 代理的是哪一个方法
		 * System.out.println(signature.getName()); // AOP代理类的名字
		 * System.out.println(signature.getDeclaringTypeName()); //
		 * AOP代理类的类（class）信息 signature.getDeclaringType();
		 */
		System.out.println("前置通知执行了!!!!");
	}

}
