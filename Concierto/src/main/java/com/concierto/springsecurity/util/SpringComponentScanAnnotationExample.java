package com.concierto.springsecurity.util;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "com.concierto.springmvc" })
public class SpringComponentScanAnnotationExample {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        try {
            ctx.register(SpringComponentScanAnnotationExample.class);
            ctx.refresh();
            System.out.println("passwordEncoder: " +
            ctx.getBean("passwordEncoder"));
           
        } finally {
            ctx.close();
        }
    }
}
