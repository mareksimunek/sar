package cz.fav.sar.server.main;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
 
@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { "cz.fav.sar.server.controllers", "cz.fav.sar.server.notifications" } )
public class MVCConfiguration extends WebMvcConfigurerAdapter {
 
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
    
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
			.allowedOrigins("https://mareksimunek.github.io") // add your origins here, for testing
			.allowedMethods("POST", "GET", "OPTIONS", "PUT", "DELETE")
			.maxAge(3600);
	} 
}