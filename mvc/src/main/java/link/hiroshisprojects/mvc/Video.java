package link.hiroshisprojects.mvc;

import javax.validation.constraints.NotNull;

public class Video {
	@NotNull(message="Name cannot be null")
	private String name;

	private String url;
	private long duration;

	public Video() {}

	public Video(String name, String url, long duration) {
		this.name = name;
		this.url = url;
		this.duration = duration;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public long getDuration() {
		return duration;
	}
	public void setDuration(long duration) {
		this.duration = duration;
	}
	@Override
	public String toString() {
		return "Video [name=" + name + ", url=" + url + ", duration=" + duration + "]";
	}


}

	
