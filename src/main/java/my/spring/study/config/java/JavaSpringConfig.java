package my.spring.study.config.java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "my.spring.study")
public class JavaSpringConfig {
    @Bean(name = "myBeanShowLifeCycle", initMethod = "customInit", destroyMethod = "customDestroy")
    public SpringBeanToShowItsLifeCycle getBean() {
//        SpringBeanToShowItsLifeCycle springBeanToShowItsLifeCycle = new SpringBeanToShowItsLifeCycle();
        SpringBeanToShowItsLifeCycle springBeanToShowItsLifeCycle = new SpringBeanToShowItsLifeCycle("SpringBeanToShowItsLifeCycle: the class property set by constructor in @Configuration");
        springBeanToShowItsLifeCycle.setStringProperty("SpringBeanToShowItsLifeCycle: the class property set by setter in @Configuration");
        return springBeanToShowItsLifeCycle;
    }
}
