package com.edpay.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

@Service
public class StaticContextHolder implements ApplicationContextAware {

    public static org.springframework.context.ApplicationContext CONTEXT;

    public static <T> T getBean(Class<T> cls) {
        return CONTEXT.getBean(cls);
    }

    @Override
    public void setApplicationContext(ApplicationContext arg0) throws BeansException {
        System.out.println("Ctx setter");
        CONTEXT = arg0;

    }
}
