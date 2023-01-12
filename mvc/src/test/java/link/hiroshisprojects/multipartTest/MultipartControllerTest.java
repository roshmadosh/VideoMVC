package link.hiroshisprojects.multipartTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import link.hiroshisprojects.multipart.MultipartController;
import link.hiroshisprojects.mvc.UploadFileRequestBuilder;
import link.hiroshisprojects.mvc.WebTestConfig;

class MultipartControllerTest {

	private UploadFileRequestBuilder requestBuilder;

	@BeforeEach
	void configureSystemUnderTest() {
		MultipartController multipartController = new MultipartController();
		MockMvc mockMvc = MockMvcBuilders
			.standaloneSetup(multipartController)
			.setHandlerExceptionResolvers(WebTestConfig.exceptionResolver())
			.setViewResolvers(WebTestConfig.jspViewResolver())
			.build();

		requestBuilder = new UploadFileRequestBuilder(mockMvc);
	}


	@Nested
	@DisplayName("Render the contents of where files are saved.")
	class index {

		@Nested
		@DisplayName("When no file uploaded by user.")
		class WhenNoFileUploaded {

			@Test
			@DisplayName("then status code is 400")
			void thenReturnHttpStatusBadRequest() throws Exception {
				requestBuilder.index().andExpect(status().isBadRequest());
			}
		}

	}
}

