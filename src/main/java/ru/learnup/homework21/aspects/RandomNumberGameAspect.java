package ru.learnup.homework21.aspects;

import com.google.common.base.Stopwatch;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RandomNumberGameAspect {

    private static final Logger log = LoggerFactory.getLogger(RandomNumberGameAspect.class);

    @Around("@annotation(ru.learnup.homework21.aspects.annotations.WorkTime)")
    public Object workTime(ProceedingJoinPoint joinPoint) throws Throwable {
        Stopwatch timer = Stopwatch.createStarted();
        log.info("the method's name is {}", joinPoint.getSignature().getName());
        Object result = joinPoint.proceed();
        log.info("the method's work time is {}", timer.stop());
        return result;
    }

    @Around("@annotation(ru.learnup.homework21.aspects.annotations.LogMethod)")
    public Object logMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = joinPoint.proceed();
        log.info("the method's name is {}", joinPoint.getSignature().getName());
        log.info("the methods parameters are {}", joinPoint.getArgs());
        log.info("the method's return value is {}", result);
        return result;
    }
}
