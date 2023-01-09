package link.hiroshisprojects.mvc;

import java.io.File;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import link.hiroshisprojects.multipart.MultipartFileConfig;

public class FrontControllerConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

	private int maxUploadSizeInBytes = 5 * 1024 * 1024; // 5MB, 1024 Bytes = 1KB

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


	@Override
	protected void customizeRegistration(ServletRegistration.Dynamic registration) {
		File tempDir = new File(System.getProperty("java.io.tmpdir"));

		MultipartConfigElement multipartConfigElement = 
			new MultipartConfigElement(tempDir.getAbsolutePath(), maxUploadSizeInBytes, maxUploadSizeInBytes * 2, maxUploadSizeInBytes /2);

		registration.setMultipartConfig(multipartConfigElement);
	}
}
