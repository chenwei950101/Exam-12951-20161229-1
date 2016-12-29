package com.hand.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 
 */
@Component
@Aspect
public class AopService {
    @Pointcut("execution(* com.hand.service.*.*(..))")
    public void run(){

    }

    @Around("run()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable{
        long begin=System.nanoTime();
        Object o=pjp.proceed();
        long end=System.nanoTime();
        System.out.print(pjp.getSignature().getName()+"方法运行时间");
        System.out.println(end-begin);
        return o;
    }
}
