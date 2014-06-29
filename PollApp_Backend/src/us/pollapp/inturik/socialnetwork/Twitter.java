package us.pollapp.inturik.socialnetwork;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import org.apache.commons.codec.binary.Base64;
import com.google.appengine.api.memcache.Expiration;
import com.google.appengine.api.memcache.MemcacheService;
import com.google.appengine.api.memcache.MemcacheServiceFactory;
import com.google.appengine.labs.repackaged.org.json.JSONArray;
import com.google.appengine.labs.repackaged.org.json.JSONObject;

import us.pollapp.inturik.DTO.TweetDTO;
import us.pollapp.inturik.util.Constant;

public class Twitter {

	public static String getTokenAuthorization() {
		HttpURLConnection httpConnection = null;
		OutputStream outputStream = null;
		BufferedReader bufferedReader = null;
		StringBuilder response = null;

		try {

			URL url = new URL(Constant.URL_AUTHENTICATION);
			httpConnection = (HttpURLConnection) url.openConnection();
			httpConnection.setRequestMethod("POST");
			httpConnection.setDoOutput(true);
			httpConnection.setDoInput(true);

			String accessCredential = Constant.CONSUMER_KEY + ":"
					+ Constant.CONSUMER_SECRET;
			String authorization = "Basic "
					+ Base64.encodeBase64String(accessCredential.getBytes());
			String param = "grant_type=client_credentials";

			httpConnection.addRequestProperty("Authorization", authorization);
			httpConnection.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded;charset=UTF-8");
			httpConnection.connect();

			outputStream = httpConnection.getOutputStream();
			outputStream.write(param.getBytes());
			outputStream.flush();
			outputStream.close();

			bufferedReader = new BufferedReader(new InputStreamReader(
					httpConnection.getInputStream()));
			String line;
			response = new StringBuilder();

			while ((line = bufferedReader.readLine()) != null) {
				response.append(line);
			}

		} catch (Exception e) {
			e.getMessage();
		} finally {
			if (httpConnection != null) {
				httpConnection.disconnect();
			}
		}
		return response.toString();
	}

	public static ArrayList<TweetDTO> getTweets(int count, long maxId) {

		String query = Constant.URL_SEARCH + "&count=" + count + "&max_id="
				+ maxId + "&include_rts=true";

		return getTweets(query);

	}

	public static ArrayList<TweetDTO> getTweets(int count) {

		String query = Constant.URL_SEARCH + "&count=" + count
				+ "&include_rts=true";

		return getTweets(query);

	}

	public static ArrayList<TweetDTO> getTweets(String urlQuery) {

		ArrayList<TweetDTO> tweets = new ArrayList<TweetDTO>();

		HttpURLConnection httpConnection = null;
		BufferedReader bufferedReader = null;
		StringBuilder response = new StringBuilder();

		try {

			MemcacheService objCache = MemcacheServiceFactory
					.getMemcacheService();

			String jsonToken = null;

			if (!objCache.contains(Constant.KEY_CACHE_TOKEN_TWEETS)) {
				jsonToken = getTokenAuthorization();
				objCache.put(
						Constant.KEY_CACHE_TOKEN_TWEETS,
						jsonToken,
						Expiration
								.byDeltaSeconds(Constant.SECONDS_EXPIRATION_TWEETS));
			} else {
				jsonToken = (String) objCache
						.get(Constant.KEY_CACHE_TOKEN_TWEETS);
			}

			URL url = new URL(urlQuery);
			httpConnection = (HttpURLConnection) url.openConnection();
			httpConnection.setRequestMethod("GET");

			JSONObject jsonObjectDocument = new JSONObject(jsonToken);

			String token = jsonObjectDocument.getString("token_type") + " "
					+ jsonObjectDocument.getString("access_token");

			httpConnection.setRequestProperty("Authorization", token);
			httpConnection.setRequestProperty("Content-Type",
					"application/json");
			httpConnection.connect();

			bufferedReader = new BufferedReader(new InputStreamReader(
					httpConnection.getInputStream()));

			String line;
			while ((line = bufferedReader.readLine()) != null) {
				response.append(line);
			}

			JSONArray jsonArray = new JSONArray(response.toString());
			JSONObject object;

			TweetDTO tweetDTO;

			for (int i = 0; i < jsonArray.length(); i++) {
				object = (JSONObject) jsonArray.getJSONObject(i);
				tweetDTO = new TweetDTO();
				tweetDTO.setId(object.getString("id_str"));
				tweetDTO.setName(object.getJSONObject("user").getString("name"));
				tweetDTO.setScreenName(object.getJSONObject("user").getString(
						"screen_name"));
				tweetDTO.setProfileImageURL(object.getJSONObject("user")
						.getString("profile_image_url"));
				tweetDTO.setText(object.getString("text"));
				tweetDTO.setCreatedAt(object.getString("created_at"));
				tweets.add(i, tweetDTO);
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (httpConnection != null) {
				httpConnection.disconnect();
			}
		}

		return tweets;

	}

}
