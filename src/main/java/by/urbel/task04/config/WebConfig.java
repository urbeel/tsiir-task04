package by.urbel.task04.config;

import by.urbel.task04.controller.constants.Routes;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Value("${client.url}")
    private String clientUrl;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping(Routes.API_PREFIX + "/**").allowedOrigins(clientUrl)
                .allowedMethods("*");
    }
}
