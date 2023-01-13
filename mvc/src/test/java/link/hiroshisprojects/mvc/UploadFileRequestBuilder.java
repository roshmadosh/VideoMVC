package link.hiroshisprojects.mvc;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMultipartHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.request.RequestPostProcessor;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import java.io.File;

import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockMultipartFile;
public class UploadFileRequestBuilder {
	private final MockMvc mockMvc;

	public UploadFileRequestBuilder(MockMvc mockMvc) {
		this.mockMvc = mockMvc;
	}

	public ResultActions index() throws Exception {
		return mockMvc.perform(get("/"));
	}

	public ResultActions uploadSingleFile(MockMultipartFile file) throws Exception {
		MockMultipartHttpServletRequestBuilder builder = 
			MockMvcRequestBuilders.multipart("/upload");

		builder.with(new RequestPostProcessor() {
			@Override
			public MockHttpServletRequest postProcessRequest(MockHttpServletRequest request) {
				request.setMethod("POST");
				return request;
			}
		});
		return mockMvc.perform(builder.file(file));
	}
}

