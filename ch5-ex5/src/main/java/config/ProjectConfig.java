package config;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import services.CommentService;

@Configuration
public class ProjectConfig {
    @Bean
    // 생성할 Bean의 Scope를 Prototype 방식으로 변경한다.
    // 따라서, CommentService 설계도가 Context에 저장되고,
    // CommentService가 참조될 때마다 새로운 Instance가 생성되어 반환되는 구조가 됨
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public CommentService commentService() {
        return new CommentService();
    }
}