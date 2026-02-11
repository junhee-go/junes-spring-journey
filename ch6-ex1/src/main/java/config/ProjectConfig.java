package config;

import aspects.LoggingAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "services")
@EnableAspectJAutoProxy // Aspect 활성화
public class ProjectConfig {
    @Bean // Aspect Class의 Instance를 Context에 추가
    public LoggingAspect aspect() { //
        return new LoggingAspect();
    }
}