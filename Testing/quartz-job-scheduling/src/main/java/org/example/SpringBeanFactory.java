package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class SpringBeanFactory {

    private static ApplicationContext appContext;
    public SpringBeanFactory(ApplicationContext applicationContext) {
        appContext = applicationContext;
    }
    public static <T> T getBean(Class<T> beanClass) {
        return appContext.getBean(beanClass);
    }
}
