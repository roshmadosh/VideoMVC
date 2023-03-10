package link.hiroshisprojects;

import java.io.File;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import link.hiroshisprojects.error.ErrorConfig;
import link.hiroshisprojects.multipart.MultipartFileConfig;
import link.hiroshisprojects.mvc.WebMvcConfig;

public class FrontControllerConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

	private int maxUploadSizeInBytes = 5 * 1024 * 1024; // 5MB, 1024 Bytes = 1KB

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null; 
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { MainConfig.class, WebMvcConfig.class, MultipartFileConfig.class, ErrorConfig.class }; 
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}


	@Override
	protected void customizeRegistration(ServletRegistration.Dynamic registration) {
		// Location for saving Multipart files
		File tempDir = new File(System.getProperty("java.io.tmpdir"));

		MultipartConfigElement multipartConfigElement = 
			new MultipartConfigElement(tempDir.getAbsolutePath(), maxUploadSizeInBytes, maxUploadSizeInBytes * 2, maxUploadSizeInBytes /2);

		registration.setMultipartConfig(multipartConfigElement);

		// Log level
		registration.setInitParameter("enableLoggingRequestDetails", "true");
	}
}
