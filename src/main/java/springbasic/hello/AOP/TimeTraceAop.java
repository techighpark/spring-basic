package springbasic.hello.AOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class TimeTraceAop {
    @Around("execution(* springbasic.hello..*(..)) && !target(springbasic.hello.SpringConfig)")
    public Object excute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
            //System.out.println("start" + joinPoint.toString());
        try {
            return joinPoint.proceed();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("end" + joinPoint + " " +timeMs + "ms");
        }
    }
}
