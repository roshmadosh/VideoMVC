package link.hiroshisprojects.mvc;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import link.hiroshisprojects.multipart.MultipartFileConfig;

public class FrontControllerConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null; 
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { WebMvcConfig.class, MultipartFileConfig.class }; 
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/video/*", "/multipart/*" };
	}

}
