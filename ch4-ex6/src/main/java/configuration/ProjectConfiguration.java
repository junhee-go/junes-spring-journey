package configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(
        basePackages = { "services", "repositories", "proxies" })
public class ProjectConfiguration {
}