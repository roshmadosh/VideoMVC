package link.hiroshisprojects.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VideoServlet extends HttpServlet {

	public static final String VIDEO_ADDED = "Video added.";

	private List<Video> videos = new ArrayList<>();

	public VideoServlet() {
		System.out.println("Initializing Video Servlet...");
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		
		resp.setContentType("text/plain");

		PrintWriter sendToClient = resp.getWriter();

		for (Video v: videos) {
			sendToClient.write(v.getName() + " : " + v.getUrl() + "\n");
		}

	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {

		String name = req.getParameter("name");
		String url = req.getParameter("url");
		String durationStr = req.getParameter("duration");

		long duration = -1;

		resp.setContentType("text/plain");

		if (name == null || url == null || durationStr == null) {
			resp.sendError(400, "Missing params. Name: " + name +
					" URL: " + url + "duration: " + duration);
		} else {
			Video v = new Video(name, url, duration);

			videos.add(v);

			resp.getWriter().write(VIDEO_ADDED);
		}

	}
}
