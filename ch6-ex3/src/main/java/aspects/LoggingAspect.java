package aspects;

import model.Comment;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
public class LoggingAspect {
    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Around("execution(* services.*.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
           String methodName = joinPoint.getSignature().getName();
           Object[] arguments = joinPoint.getArgs();

        logger.info("Method " + methodName +
                " with parameters " + Arrays.asList(arguments) +
                " will execute");

        // joinPoint에는 원본 method 호출 시에 전달된 params가 저장돼 있지만,
        // aspect logic에서 새로운 param을 생성!
        Comment newComment = new Comment();
        newComment.setAuthor("David");
        newComment.setText("some other text!");
        Object[] newArguments = {newComment}; // 원본 메서드 호출할 때 전달하는 인자는 object[] 타입..

        // 새로 만든 param을 인자로 원본 메서드 호출!
        Object returnedByTargetMethod = joinPoint.proceed(newArguments);

        // 원본 메서드로부터 반환된 값을 logging
        logger.info("Method executed and returned " + returnedByTargetMethod);

        // 원본 메서드에선 "SUCCESS"를 return하지만,
        // aspect logic에서 전혀 다른 값을 원본 메서드를 호출한 곳(main())에 return 한다!
        return "FAILED";
    }
}