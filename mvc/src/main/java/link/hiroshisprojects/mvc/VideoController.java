package link.hiroshisprojects.mvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class VideoController {

	private List<Video> videos = new ArrayList<>(Arrays.asList(new Video("Jackie Chan Adventures", "google.com", 8000000)));	

	@GetMapping("/video")
	public String getVideos() {
		return "Title: " + videos.get(0).getName() + " URL: " + videos.get(0).getUrl();
	}
}

