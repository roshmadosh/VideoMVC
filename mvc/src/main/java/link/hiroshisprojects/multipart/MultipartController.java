package link.hiroshisprojects.multipart;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/health")
public class MultipartController {
	
	@GetMapping
	public String healthCheck() {
		return "Health check successful.";
	}
}
