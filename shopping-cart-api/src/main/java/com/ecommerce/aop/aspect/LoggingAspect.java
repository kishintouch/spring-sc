package com.ecommerce.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class LoggingAspect {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//What kind of method calls I would intercept
    //execution(* PACKAGE.*.*(..))
    //Weaving & Weaver
	//Below execution pointcut will interpert all calls with given package
    @Before("execution(* com.ecommerce.products.*.*.*(..))")
    public void before(JoinPoint joinPoint) {
        //Advice
        logger.info(" Check for user access ");
        logger.info(" Before Allowed execution for {}", joinPoint);
    }
    
  //Below execution pointcut will interpert all calls with given package.classname .All methods in class
    @After("execution(* com.ecommerce.products.controller.ProductsController.*(..))")
    public void after(JoinPoint joinPoint) {
        //Advice
        logger.info(" Check for user access ");
        logger.info(" after Execution is completed for ", joinPoint);
    }
    
    //@Around , @AfterReturning , @AfterThrowing - other types of advice
	
    @Around("@annotation(com.ecommerce.java.annotations.LogTime)")
    public Object  around(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long timeTaken = System.currentTimeMillis() - startTime;
        logger.info("Time Taken by {} is {}", joinPoint, timeTaken);
        
        return result;
    }
    
    
	

}
