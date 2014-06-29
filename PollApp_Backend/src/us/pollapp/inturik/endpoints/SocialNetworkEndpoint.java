package us.pollapp.inturik.endpoints;

import java.util.List;

import us.pollapp.inturik.DTO.ContextResponseDTO;
import us.pollapp.inturik.DTO.TweetDTO;
import us.pollapp.inturik.DTO.Messages.MsgGetAllTweetsResponse;
import us.pollapp.inturik.endpoints.utils.UtilContext;
import us.pollapp.inturik.socialnetwork.Twitter;
import us.pollapp.inturik.util.Error;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;
import com.google.api.server.spi.config.Named;

@Api(name = "socialnetworkendpoint", namespace = @ApiNamespace(ownerDomain = "pollapp.us", ownerName = "pollapp.us", packagePath = "inturik.endpoints"), version = "v1")
public class SocialNetworkEndpoint {

	@ApiMethod(name = "getAllTweetsPagination", path = "getAllTweetsPagination", httpMethod = HttpMethod.GET)
	public MsgGetAllTweetsResponse getAllTweetsPagination(
			@Named("count") int count, @Named("maxId") long maxId)
			throws Exception {

		try {

			MsgGetAllTweetsResponse msgResponse = new MsgGetAllTweetsResponse();

			ContextResponseDTO contextResponse = UtilContext
					.getFillContextResponseDTOBasic("test");
			msgResponse.setContextResponse(contextResponse);

			List<TweetDTO> lstTweets;

			if (maxId == 0) {
				lstTweets = Twitter.getTweets(count);
			} else {
				lstTweets = Twitter.getTweets(count, maxId);
			}

			msgResponse.setTweets(lstTweets);

			return msgResponse;

		} catch (Exception e) {
			Error.SendError(e.getMessage());
			throw e;
		}
	}

	@ApiMethod(name = "getAllTweetsPagination2", path = "getAllTweetsPagination2", httpMethod = HttpMethod.GET)
	public MsgGetAllTweetsResponse getAllTweetsPagination2(
			@Named("idTransaction") String idTransaction,
			@Named("user") String user,
			@Named("application") String application,
			@Named("count") int count, @Named("maxId") long maxId)
			throws Exception {

		try {

			MsgGetAllTweetsResponse msgResponse = new MsgGetAllTweetsResponse();

			ContextResponseDTO contextResponse = UtilContext
					.getFillContextResponseDTOBasic(idTransaction);
			msgResponse.setContextResponse(contextResponse);

			List<TweetDTO> lstTweets;

			if (maxId == 0) {
				lstTweets = Twitter.getTweets(count);
			} else {
				lstTweets = Twitter.getTweets(count, maxId);
			}

			msgResponse.setTweets(lstTweets);

			return msgResponse;

		} catch (Exception e) {
			Error.SendError(e.getMessage());
			throw e;
		}
	}

}
