package org.springaop.user;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 	切面，扩展原来类的功能，提供日志记录功能
 * @author Huaiku
 * @date Dec 12, 2018
 */
@Aspect
@Component
public class LoggerAspect {
	private static Logger logger = LoggerFactory.getLogger(LoggerAspect.class);

	@Around("execution(* org..UserHandler.getUserName(..))")
	public String processRecord(ProceedingJoinPoint joinPoint) {
		
		logger.info("即将开始调用UserHandler getUserName()方法...此日志时通过切面的方式记录");
		Object returnValue = null;
		try {
			returnValue = joinPoint.proceed();
			logger.info("调用方法完毕，方法返回结果为：{}", returnValue.toString());
		} catch (Throwable e) {
			logger.error("方法调时产生了一个错误，错误信息如下：{}", e.getMessage());
		}

		return returnValue.toString();
	}
}
