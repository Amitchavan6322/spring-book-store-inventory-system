package com.amit.book.inventory.util;


import lombok.Getter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringContextUtil {

    @Getter
    private static final ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

    private SpringContextUtil() {
        // private constructor to prevent instantiation
    }

}