package us.pollapp.inturik.DTO.Messages;

import java.util.List;

import us.pollapp.inturik.DTO.ContextResponseDTO;
import us.pollapp.inturik.DTO.TweetDTO;

public class MsgGetAllTweetsResponse {

	private ContextResponseDTO contextResponse;
	private List<TweetDTO> lstTweets;

	public ContextResponseDTO getContextResponse() {
		return contextResponse;
	}

	public void setContextResponse(ContextResponseDTO contextResponse) {
		this.contextResponse = contextResponse;
	}

	public List<TweetDTO> getTweets() {
		return lstTweets;
	}

	public void setTweets(List<TweetDTO> lstTweets) {
		this.lstTweets = lstTweets;
	}
}
