package br.com.NEOS_Education.API.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/api/**") //Permite que o CORS acesse todos os endpoints que começam com '/api'
                .allowedOrigins("https://becaaa123.github.io/NEOS_Education/") //URL do front
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
    }
}
