package link.hiroshisprojects.error;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class ExceptionHandlers {

	/**
	*	Catches exception thrown by @Valid in MVC controllers 
	*/
	@ExceptionHandler
	public String handleMethodArgumentNotValidException(MethodArgumentNotValidException e, 
														RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
		return "redirect:error"; 
	}
}
