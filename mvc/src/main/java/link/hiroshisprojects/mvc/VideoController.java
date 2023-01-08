package link.hiroshisprojects.mvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/video")
public class VideoController {

	private List<Video> videos = new ArrayList<>(Arrays.asList(new Video("Jackie Chan Adventures", "google.com", 800)));	

	@GetMapping
	public List<Video> getVideos() {
		return videos; 
	}
	
	@GetMapping("/search")
	public Video findVideos(@RequestParam("maxDuration") Long maxDuration) {
		List<Video> filtered = videos.stream()
			.filter(v -> v.getDuration() < maxDuration)
			.collect(Collectors.toList());

		if (filtered.isEmpty()) {
			return null; 
		} else {
			return filtered.get(0); 
		}
	}			

	@PostMapping
	public Video addVideo(@RequestBody Video video) {
		videos.add(video);	
		return video; 
	}
}

