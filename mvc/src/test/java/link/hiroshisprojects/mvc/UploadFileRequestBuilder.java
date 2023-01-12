package link.hiroshisprojects.mvc;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
public class UploadFileRequestBuilder {
	private final MockMvc mockMvc;

	public UploadFileRequestBuilder(MockMvc mockMvc) {
		this.mockMvc = mockMvc;
	}

	public ResultActions index() throws Exception {
		return mockMvc.perform(get("/"));
	}
}

