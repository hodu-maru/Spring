package com.example.ch05_moreaboutspring.DI;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ApplicationContextProvider implements ApplicationContextAware {

    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
                                        //spring이 알아서 주입해줌
        context = applicationContext;
    }

    public static ApplicationContext getContext() {
        return context;
    }
}
