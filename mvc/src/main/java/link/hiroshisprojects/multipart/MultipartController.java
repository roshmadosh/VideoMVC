package link.hiroshisprojects.multipart;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/multipart")
public class MultipartController {
	
	@GetMapping
	public String index() {
		return "upload";
	}
}
