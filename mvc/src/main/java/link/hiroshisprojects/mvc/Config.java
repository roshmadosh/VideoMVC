package link.hiroshisprojects.mvc;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;


public class Config implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext sc) throws ServletException {
		XmlWebApplicationContext ctx = 
			new XmlWebApplicationContext();
		ctx.setConfigLocation("/WEB-INF/dispatcher-config.xml");

		ServletRegistration.Dynamic reg = sc.addServlet("dispatcher", new DispatcherServlet(ctx));
		reg.setLoadOnStartup(1);
		reg.addMapping("/");
	}
}
