package org.spring.utils;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Getter
public class ContextUtil {

    private AnnotationConfigApplicationContext INSTANCE;

    @PostConstruct
    public void init() {
        INSTANCE = new AnnotationConfigApplicationContext(AppConfig.class);
    }

}
