package cz.fav.sar.server.main;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

import cz.fav.sar.server.utils.CommunicationValidator;
import cz.fav.sar.server.utils.Notificator;
import cz.fav.sar.server.utils.ReportFiller;
import cz.fav.sar.server.utils.ReportValidator;

public class WebAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext container) throws ServletException {
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(RepositoryConfig.class);
		ctx.register(MVCConfiguration.class);
		ctx.register(SecurityConfiguration.class);
		ctx.setServletContext(container);

		ServletRegistration.Dynamic servlet = container.addServlet("dispatcher", new DispatcherServlet(ctx));

        EnumSet<DispatcherType> dispatcherTypes = EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD);
        FilterRegistration.Dynamic security = container.addFilter(AbstractSecurityWebApplicationInitializer.DEFAULT_FILTER_NAME, new DelegatingFilterProxy());
        security.addMappingForUrlPatterns(dispatcherTypes, true, "/*");
        
		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");
		ReportValidator.init(ctx);
		CommunicationValidator.init(ctx);
		ReportFiller.init(ctx);
		Notificator notificator = new Notificator();
		notificator.start();
	}

}