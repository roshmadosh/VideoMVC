package link.hiroshisprojects.mvc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/hello")
public class HomeController {

	@GetMapping
	public String getHomePage() {
		return "hello"; 
	}
}
