package my.spring.study.config.java;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class SpringBeanToShowItsLifeCycle implements InitializingBean, DisposableBean, BeanFactoryAware, BeanNameAware, BeanClassLoaderAware, ApplicationContextAware {

    private ApplicationContext applicationContext;
    private String stringProperty;

    public SpringBeanToShowItsLifeCycle() {
        System.out.println("SpringBeanToShowItsLifeCycle: inside constructor with no params");
    }

    public SpringBeanToShowItsLifeCycle(String stringProperty) {
        this.stringProperty = stringProperty;
        System.out.println("SpringBeanToShowItsLifeCycle: inside custom constructor with params");
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("SpringBeanToShowItsLifeCycle: BeanClassLoaderAware.setBeanClassLoader");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("SpringBeanToShowItsLifeCycle: BeanNameAware.setBeanName");
    }

    @PostConstruct
    public void springPostConstruct() {
        System.out.println("SpringBeanToShowItsLifeCycle: @PostConstruct");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("SpringBeanToShowItsLifeCycle: BeanFactoryAware.setBeanFactory");
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("SpringBeanToShowItsLifeCycle: InitializingBean.afterPropertiesSet");
    }

    String getStringProperty() {
        return stringProperty;
    }

    void setStringProperty(String stringProperty) {
        this.stringProperty = stringProperty;
        System.out.println("SpringBeanToShowItsLifeCycle: set the class property by setter");
    }

    @PreDestroy
    public void springPreDestroy() {
        System.out.println("SpringBeanToShowItsLifeCycle: @PreDestroy");
    }

    @Override
    public void destroy() {
        System.out.println("SpringBeanToShowItsLifeCycle: DisposableBean.destroy");
    }

    @Override
    protected void finalize() {
        System.out.println("SpringBeanToShowItsLifeCycle: inside finalize");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        System.out.println("SpringBeanToShowItsLifeCycle: ApplicationContextAware.setApplicationContext");
    }
}
