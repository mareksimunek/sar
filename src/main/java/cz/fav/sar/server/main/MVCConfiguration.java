package cz.fav.sar.server.main;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
 
@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { "cz.fav.sar.server.controllers" })
public class MVCConfiguration extends WebMvcConfigurerAdapter {
 
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
 
}