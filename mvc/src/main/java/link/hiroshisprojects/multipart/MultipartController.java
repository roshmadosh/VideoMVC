package link.hiroshisprojects.multipart;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MultipartController {
	private final String filepath;

	public MultipartController() {
		String os = System.getProperty("os.name");

		if (os.equals("Linux")) {
			filepath = "/tmp/VideoMVC";
		} else {
			filepath = null;
		}
	}

	@GetMapping
	public ModelAndView index(RedirectAttributes redirectAttributes) {

		File folder  = new File(filepath);
		List<String> contents = new ArrayList<>();
		for(final File file : folder.listFiles()) {
			contents.add(file.getName());
		}

		ModelAndView mv = new ModelAndView("upload");
		
		mv.addObject("files", contents);
		return mv;
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

		if(filepath.isBlank()) {
			redirectAttributes.addFlashAttribute("errorMessage", "Filepath not set on non-Linux machines.");
			return "redirect:error";
		}

		try {
			byte[] bytes = file.getBytes();
			Path path = Paths.get(filepath + file.getOriginalFilename());
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
