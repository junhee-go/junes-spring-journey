package aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.logging.Logger;

@Aspect
// @Aspect Annotation은 Stereotype Annotation이 아니다. 이 클래스가 Aspect 정의를 구현한다고 스프링에게 알려주는 것 뿐
// 즉, @Aspect 쓴다고 Context에 추가되지 않음
// Aspect Class의 인스턴스를 Context에 추가할 때, 스테레오타입 애너테이션 쓸 거였다면,
// @Component와 같은 스테레오타입 애너테이션을 써야만 함
// 지금은 Configuration Class에서 @Bean을 통해 Context에 추가하므로 논외
public class LoggingAspect {
    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Around("execution(* services.*.*(..))") // 언제, 어떤 메서드를 가로챌 것인지 스프링에 지시
    // Around: advice
    // execution(...): pointcut(어떤 메시드를 가로챌지)
    public void log(ProceedingJoinPoint joinPoint) throws Throwable { // aspect method
        logger.info("Target Method will execute"); // 가로챌 메서드 실행 전 출력
        joinPoint.proceed(); // 가로챌 메서드(원본 메서드=publishComment() of CommentService Class) 호출
        // pointcut을 보면, services 패키지 내 모든 클래스의 모든 메서드를 가로채는 거니까..
        logger.info("Target Method executed"); // 가로챈 메서드 실행 후 출력
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }
}