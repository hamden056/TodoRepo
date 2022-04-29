package com.example.TodoBack;


import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfiguration {
    public class WebConfig implements WebMvcConfigurer{
        @Override
        public void addCorsMappings(CorsRegistry corsRegistry ) {
            corsRegistry.addMapping("/**").allowedOrigins("http://localhost:4200").allowedMethods(
                    "GET", "POST", "PUT", "DELETE"
            );
        }
    }
}