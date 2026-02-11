package aspects;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // 리텐션 정책을 runtime으로 설정
@Target(ElementType.METHOD) // 현재 만들고 있는 annotation이 method에만 사용되도록 제한
public @interface ToLog {
}