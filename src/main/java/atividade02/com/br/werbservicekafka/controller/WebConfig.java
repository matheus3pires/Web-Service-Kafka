package atividade02.com.br.werbservicekafka.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Permitir CORS em todas as rotas
                .allowedOrigins("http://127.0.0.1:5501") // Permitir requisições da origem especificada
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Métodos permitidos
                .allowCredentials(true); // Permitir cookies, se necessário
    }
}
