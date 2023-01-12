package link.hiroshisprojects.mvc;

import java.util.Properties;

import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

public final class WebTestConfig {

	// not sure why this class is not static, but tutorial does this.
	private WebTestConfig() {}

	public static SimpleMappingExceptionResolver exceptionResolver() {
		// Maps thrown exceptions to ViewResolver pages
		SimpleMappingExceptionResolver exceptionResolver =
			new SimpleMappingExceptionResolver();

		// Properties are a call that contain key-value pairs of different file locations, i think
		Properties exceptionMappings = new Properties();

		exceptionMappings.put("java.lang.MethodArgumentNotValidException", "error");
		exceptionResolver.setExceptionMappings(exceptionMappings);

		Properties statusCodes = new Properties();

		statusCodes.put("error", "404");
		exceptionResolver.setStatusCodes(statusCodes);

		return exceptionResolver;

	}

	public static ViewResolver jspViewResolver() {
		InternalResourceViewResolver viewResolver = 
			new InternalResourceViewResolver();


		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views");
		viewResolver.setSuffix(".jsp");

		return viewResolver;

	}
}
