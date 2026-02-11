package aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
public class LoggingAspect {
    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Around("execution(* services.*.*(..))") // advice and pointcut
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName(); // 가로챈 메서드의 이름을 가져옴
        Object[] arguments = joinPoint.getArgs(); // 가로챌 메서드를 호출했을 때 전달한 매개변수를 가져옴

        // 가로챌 메서드의 이름과 파라미터를 logging
        logger.info("Method: " + methodName +
                " with Parameters " + Arrays.asList(arguments) + " will execute");
        Object returnedByTargetMethod = joinPoint.proceed(); // 가로챌 메서드 호출 및 반환값 저장
        logger.info("Method executed and returned " + returnedByTargetMethod);

        return returnedByTargetMethod; // 가로챈 메서드의 반환값을 return
    }
}