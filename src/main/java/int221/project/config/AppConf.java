package int221.project.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConf implements WebMvcConfigurer {
    @Value("#{'GET, PUT, HEAD, POST, DELETE, OPTION'.split(', ')}")
    private String[] methodList;

    @Value("#{'http://frontend, http://localhost:8080, http://13.76.186.187'.split(', ')}")
    String[] hostList;

    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**").allowedOrigins(hostList).allowedMethods(methodList);
    }
}
