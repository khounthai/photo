package com.pict;

import java.net.URL;

import org.hibernate.validator.internal.util.privilegedactions.GetClassLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;


@SpringBootApplication
public class Application {
	
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @Bean
    public ClassLoaderTemplateResolver yourTemplateResolver() {
        ClassLoaderTemplateResolver yourTemplateResolver = new ClassLoaderTemplateResolver();
        yourTemplateResolver.setPrefix("com/pict/templates/");
        yourTemplateResolver.setSuffix(".html");
        yourTemplateResolver.setCharacterEncoding("UTF-8");
        yourTemplateResolver.setOrder(0);  // this is iportant. This way spring 
                                            //boot will listen to both places 0 
                                            //and 1
        return yourTemplateResolver; 
    }
}