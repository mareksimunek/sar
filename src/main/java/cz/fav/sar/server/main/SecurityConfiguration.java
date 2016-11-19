package cz.fav.sar.server.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("test").password("test").roles("USER");
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
	    web.ignoring().antMatchers("/login");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.csrf().disable()
				
				.addFilterBefore(new JwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
				
				.sessionManagement().sessionCreationPolicy( SessionCreationPolicy.STATELESS )
				.and()
				
				.authorizeRequests()
				.anyRequest().authenticated()
				.and()

				.exceptionHandling()
				.authenticationEntryPoint(authenticationEntryPoint())
				.accessDeniedHandler(accessDeniedHandler())
				;
	}

	private AccessDeniedHandler accessDeniedHandler() {
		return new AccessDeniedHandler() {
			@Override
			public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
				httpServletResponse.getWriter().append("Access denied");
				httpServletResponse.setStatus(403);
			}
		};
	}

	private AuthenticationEntryPoint authenticationEntryPoint() {
		return new AuthenticationEntryPoint() {
			@Override
			public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
				httpServletResponse.getWriter().append("Not authenticated");
				httpServletResponse.setStatus(401);
			}
		};
	}
}
