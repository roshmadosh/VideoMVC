package link.hiroshisprojects.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/")
@ResponseBody
public class HomeController {

	@GetMapping
	public String getHomePage() {
		return "hello"; 
	}
}
