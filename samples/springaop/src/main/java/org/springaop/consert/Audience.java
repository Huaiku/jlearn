package org.springaop.consert;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springaop.groovy.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 这是一个切面，各个方法定义切面的具体行为，每个方法代表一个通知
 * 
 * @author Huaiku
 * @date Dec 7, 2018
 */

@Component
@Aspect
public class Audience {
	private static final Logger logger = LoggerFactory.getLogger(Audience.class);

	/**
	 * 关闭手机 execution(** consert.Performance.perform(..)) 执行 **(任意返回),
	 * consert.perFormance.perform(..) (Package.Class.Method), .. (任意参数)
	 * 
	 * 通知方法会在目标方法返回或抛出异常后调用
	 */
	//@Before(Pointcut.performancePointcut)
	public void silenceCellPhone() {
		logger.info("Silenct All Cell Phone!");
	}

	/**
	 * 就坐
	 * 
	 * 通知方法会在目标方法返回或抛出异常后调用
	 */
	//@Before(Pointcut.performancePointcut)
	public void takeSeats() {
		logger.info("All Audience Take Seats..");
	}

	/**
	 * 鼓掌 通知方法会在目标方法返回后调用 Applause [əˈplɔz]
	 */
	//@AfterReturning(Pointcut.performancePointcut)
	public void applause() {
		logger.info("CLAP CLAP CLAP...");
	}

	/**
	 * 要求退款 Demand [dɪˈmænd] 需要;要求，请求;[法]召唤;询问，盘问 Refund ['ri:fʌnd] 资金偿还;偿还数额
	 * 
	 * 通知方法会在目标方法抛出异常后调用
	 */
	//@AfterThrowing(Pointcut.performancePointcut)
	public void demandRefund() {
		logger.info("Demand a refund..");
	}

	/**
	 * 创建环绕通知
	 */
	@Around(Pointcut.performancePointcut)
	public void aroundAdvice(ProceedingJoinPoint joinPoint) {
		logger.info("音乐会即将开始..观众找座位就坐...");
		logger.info("音乐会即将开始..关闭手机等通讯工具....");
		try {
			joinPoint.proceed();
			logger.info("演出非常完美...观众异常喜爱....");
		} catch (Throwable e) {
			logger.error("Demand a refund..");
		}
	}

}
