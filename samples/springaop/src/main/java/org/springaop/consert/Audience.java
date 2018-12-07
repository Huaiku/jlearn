package org.springaop.consert;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class Audience {
	private static final Logger logger= LoggerFactory.getLogger(Audience.class);
	
	/**
	 * 关闭手机
	 * execution(** consert.Performance.perform(..))
	 * 执行 **(任意返回),
	 * consert.perFormance.perform(..) (Package.Class.Method),
	 *  .. (任意参数)
	 */
	@Before("execution(** consert.Performance.perform(..))")
	public void silenceCellPhone() {
		logger.info("Silenct All Cell Phone!");
	}
	
	/**
	 * 就坐
	 */
	public void takeSeats() {
		logger.info("All Audience Take Seats..");
	}
	
	/**
	 * 鼓掌
	 * 
	 * Applause [əˈplɔz] 
	 */
	public void applause() {
		logger.info("CLAP CLAP CLAP...");
	}
	
	/**
	 * 要求退款
	 * Demand [dɪˈmænd] 需要;要求，请求;[法]召唤;询问，盘问
	 * Refund  ['ri:fʌnd] 资金偿还;偿还数额
	 */
	public void demandRefund() {
		logger.info("Demand a refund..");
	}
}
