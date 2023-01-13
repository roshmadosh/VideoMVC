package link.hiroshisprojects.multipart;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	private final String os;

	public MultipartController() {
		os = System.getProperty("os.name");

		System.out.println("Multipart Controller created...");
		if (os.equals("Linux")) {
			filepath = "/tmp/VideoMVC/";
		} else {
			filepath = null;
		}
	}

	@GetMapping
	public ModelAndView index(RedirectAttributes redirectAttributes) {
		File folder  = new File(filepath);
		if (!folder.exists() && os.equals("Linux")) {
			try {
				Files.createDirectory(Paths.get("/tmp/VideoMVC"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		List<String> contents = new ArrayList<>();
		for(final File file : folder.listFiles()) {
			contents.add(file.getName());
		}

		ModelAndView mv = new ModelAndView("upload");
		
		mv.addObject("files", contents);
		return mv;
	}

	@PostMapping("/upload")
	public ResponseEntity<String> singleFileUpload(@RequestParam("file") MultipartFile file,
									RedirectAttributes redirectAttributes) {

		if (file.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("File upload cannot be empty.");	
		}

		if(filepath.isBlank()) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Upload does not work on non-Linux machines");
		}
		try {
			byte[] bytes = file.getBytes();
			Path path = Paths.get(filepath + file.getOriginalFilename());
			Files.write(path, bytes);

			redirectAttributes.addFlashAttribute("message", "Successfully uploaded '" + file.getOriginalFilename() + "'");
		} catch (IOException e ) {
			e.printStackTrace();
		}

		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", "/error");
		return new ResponseEntity<String>(headers, HttpStatus.FOUND);
	}

	@GetMapping("/uploadStatus")
	public String uploadStatus() {
		return "uploadStatus";
	}

}
