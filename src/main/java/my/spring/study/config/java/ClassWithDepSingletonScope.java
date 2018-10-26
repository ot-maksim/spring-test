package my.spring.study.config.java;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
class ClassWithDepSingletonScope {

    @Autowired
    private ClassWithDepPrototypeScope classWithDepPrototypeScope;

    public ClassWithDepSingletonScope() {
        System.out.println("ClassWithDepSingletonScope: the class dependant classWithDepPrototypeScope's value in constructor: " + classWithDepPrototypeScope);
    }

    @PostConstruct
    void postConstruct() {
        System.out.println();
        System.out.println("ClassWithDepSingletonScope: @PostConstruct");
        System.out.println("ClassWithDepSingletonScope: the class dependant classWithDepPrototypeScope's value in @PostConstruct: " + classWithDepPrototypeScope);
        System.out.println();
    }

    void getDependentObjectStr() {
        System.out.println("ClassWithDepSingletonScope: the class dependant classWithDepPrototypeScope property toString value: " + classWithDepPrototypeScope.toString());
    }
}
