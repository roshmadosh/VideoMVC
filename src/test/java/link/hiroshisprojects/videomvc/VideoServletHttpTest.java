package link.hiroshisprojects.videomvc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.http.Consts;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;



public class VideoServletHttpTest {

	private final String TEST_URL = "http://localhost:8080/video";
	
	private final CloseableHttpClient httpClient = HttpClients.createDefault();

	@Test
	public void whenVideoAdded_theMessage() {
		String randomID = UUID.randomUUID().toString();
		String title = "Video - " + randomID;
		String url = "http://coursera.org/some/video-" + randomID;
		long duration = 1000 * 60 * 10; // 10 mins in milliseconds

		try {
	
			HttpPost post = createVideoPostRequest(title, url, duration);
			HttpResponse response = httpClient.execute(post);
			assertEquals(200, response.getStatusLine().getStatusCode());

			String responseBody = extractResponseBody(response);
			String expected = title + " : " + url + "\n";
			assertEquals(expected, responseBody);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private String extractResponseBody(HttpResponse response) throws IOException {
		return EntityUtils.toString(response.getEntity(), "UTF-8");
	}

	private HttpPost createVideoPostRequest(String title, String url, long duration) {
		HttpPost post = new HttpPost(TEST_URL);

		// name value pairs that will make up our request body
		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("name", title));
		params.add(new BasicNameValuePair("url", url));
		params.add(new BasicNameValuePair("duration", "" + duration));

		// convert name-value pairs to url encoded format to send with request
		UrlEncodedFormEntity requestBody = new UrlEncodedFormEntity(params, Consts.UTF_8);

		post.setEntity(requestBody);
		return post;
	}
}
