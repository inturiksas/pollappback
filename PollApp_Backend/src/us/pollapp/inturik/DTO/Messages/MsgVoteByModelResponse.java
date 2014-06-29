package us.pollapp.inturik.DTO.Messages;

import us.pollapp.inturik.DTO.ContextResponseDTO;

public class MsgVoteByModelResponse {

	private ContextResponseDTO contextResponse;
	private int score;

	public ContextResponseDTO getContextResponse() {
		return contextResponse;
	}

	public void setContextResponse(ContextResponseDTO contextResponse) {
		this.contextResponse = contextResponse;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
