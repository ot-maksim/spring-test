package my.spring.study.config.java;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringBeanLifeCycleDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(JavaSpringConfig.class);
        ctx.refresh();

        SpringBeanToShowItsLifeCycle springBeanToShowItsLifeCycle = ctx.getBean("myBeanShowLifeCycle", SpringBeanToShowItsLifeCycle.class);
        System.out.println("SpringBeanToShowItsLifeCycle: call the class getStringProperty(): " + springBeanToShowItsLifeCycle.getStringProperty());

        ClassWithDepPrototypeScope prototypeBean = ctx.getBean(ClassWithDepPrototypeScope.class);
        prototypeBean.getObjectStr();
        prototypeBean = ctx.getBean(ClassWithDepPrototypeScope.class);
        prototypeBean.getObjectStr();

        ClassWithDepSingletonScope singletonBean = ctx.getBean(ClassWithDepSingletonScope.class);
        singletonBean.getDependentObjectStr();
        singletonBean.getDependentObjectStr();
        ctx.close();
    }
}
