package my.spring.study.config.java;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

@Component
@Scope(SCOPE_PROTOTYPE)
class ClassWithDepPrototypeScope {

    private String classWithDepProperty;
    @Autowired
    private SpringBeanToShowItsLifeCycle springBeanToShowItsLifeCycle;

    @PostConstruct
    void postConstruct() {
        System.out.println();
        System.out.println("ClassWithDepPrototypeScope: @PostConstruct");
        classWithDepProperty = springBeanToShowItsLifeCycle.getStringProperty();
        System.out.println("ClassWithDepPrototypeScope: init the class property in @PostConstruct by the value: " + classWithDepProperty);
        System.out.println("ClassWithDepPrototypeScope: the object's toString value: " + toString());
        System.out.println();
    }

    void getObjectStr() {
        System.out.println("ClassWithDepPrototypeScope: the object's toString value: " + toString());
    }
}
