package by.clevertec.starter.performancemonitorspringbootstarter.aspect;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
@RequiredArgsConstructor
@Slf4j
public class PerformanceMonitorAspect {

    private final boolean isPresent;
    private final long minExecutionTime;

    @Pointcut("@annotation(by.clevertec.starter.performancemonitorspringbootstarter.annotation.MonitorPerformance) ")
    public void isMonitorPerformancePointcut() {
    }

    @Around("isMonitorPerformancePointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        if (isPresent) {
            long startTime = System.currentTimeMillis();
            Object result = joinPoint.proceed();
            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime - startTime;
            if (elapsedTime > minExecutionTime) {
                log.info("Method {} executed in {} ms", joinPoint.getSignature().getName(), elapsedTime);
            }
            return result;
        }
        return joinPoint.proceed();
    }
}
