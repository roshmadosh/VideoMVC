package link.hiroshisprojects.multipart;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MultipartController {
	
	@GetMapping
	public String index() {
		return "upload";
	}

	@PostMapping("/upload")
	public String singleFileUpload(@RequestParam("file") MultipartFile file,
									RedirectAttributes redirectAttributes) {

		if (file.isEmpty()) {
			// redirectAttributes.addFlashAttribute("message", "Upload failed. Please choose another to upload!");
			// return "redirect:uploadStatus";
			redirectAttributes.addFlashAttribute("errorMessage", "Please include a file to upload!");
			return "redirect:error";
		}

		try {
			byte[] bytes = file.getBytes();
			Path path = Paths.get("/tmp/" + file.getOriginalFilename());
			Files.write(path, bytes);

			redirectAttributes.addFlashAttribute("message", "Successfully uploaded '" + file.getOriginalFilename() + "'");
		} catch (IOException e ) {
			e.printStackTrace();
		}

		return "redirect:uploadStatus";
	}

	@GetMapping("/uploadStatus")
	public String uploadStatus() {
		return "uploadStatus";
	}

}
