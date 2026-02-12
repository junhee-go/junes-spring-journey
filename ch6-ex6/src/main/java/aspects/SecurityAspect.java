package aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.logging.Logger;

@Aspect
public class SecurityAspect {
    private Logger logger = Logger.getLogger(SecurityAspect.class.getName());

    @Around(value = "@annotation(ToLog)")
    public Object secure(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("Security Aspect: Calling the intercepted method");
        Object returnedValue = joinPoint.proceed();
        /*
        proceed() 메서드는 Aspect 실행 체인에 실행을 위임한다.
        이 메서드는 두 Aspect 중 하나를 호출하거나, 가로챈 메서드를 실행하게 된다.
         */
        logger.info("Security Aspect: Method executed and returned " + returnedValue);
        return returnedValue;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }
}