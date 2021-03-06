package us.pollapp.inturik.endpoints;

import java.util.List;

import us.pollapp.inturik.DTO.ContextResponseDTO;
import us.pollapp.inturik.DTO.Messages.MsgGetMatchsByRoundResponse;
import us.pollapp.inturik.DTO.Messages.MsgGetResulstMatchResponse;
import us.pollapp.inturik.DTO.Messages.MsgSetResultMatchRequest;
import us.pollapp.inturik.DTO.Messages.MsgSetResultMatchResponse;
import us.pollapp.inturik.DTO.Messages.MsgUpdateResultMatchOriginalRequest;
import us.pollapp.inturik.DTO.Messages.MsgUpdateResultMatchOriginalResponse;
import us.pollapp.inturik.businesslogic.LMatch;
import us.pollapp.inturik.endpoints.utils.UtilContext;
import us.pollapp.inturik.model.Match;
import us.pollapp.inturik.model.ResultMatch;
import us.pollapp.inturik.transformDTO.MatchTransform;
import us.pollapp.inturik.transformDTO.ResultMatchTransform;
import us.pollapp.inturik.util.Error;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.Named;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;

@Api(name = "matchendpoint", namespace = @ApiNamespace(ownerDomain = "pollapp.us", ownerName = "pollapp.us", packagePath = "inturik.endpoints"), version = "v1")
public class MatchEndpoint {

	@ApiMethod(name = "setResultMatchByUser", path = "setResultMatchByUser", httpMethod = HttpMethod.POST)
	public MsgSetResultMatchResponse setResultMatchByUser(
			MsgSetResultMatchRequest msgSetResultMatchRequest) throws Exception {

		MsgSetResultMatchResponse msgResponse = new MsgSetResultMatchResponse();

		try {

			ContextResponseDTO contextResponse = UtilContext
					.getFillContextResponseDTOBasic(msgSetResultMatchRequest
							.getContextRequestDTO());
			msgResponse.setContextResponse(contextResponse);

			LMatch objLMatch = new LMatch();

			objLMatch.setResultMatch(msgSetResultMatchRequest.getIdUser(),
					msgSetResultMatchRequest.getIdPolla(),
					msgSetResultMatchRequest.getIdMatch(),
					msgSetResultMatchRequest.getScoreTeamA(),
					msgSetResultMatchRequest.getScoreTeamB());

		} catch (Exception e) {			
			msgResponse.getContextResponse().setTransactionState(false);
			Error.SendError(e.getMessage());
			throw e;
		}

		return msgResponse;

	}

	@ApiMethod(name = "getResultsMatch", path = "getResultsMatch", httpMethod = HttpMethod.GET)
	public MsgGetResulstMatchResponse getResultsMatch(
			@Named("idTransaction") String idTransaction,
			@Named("user") String user,
			@Named("application") String application,
			@Named("pageNumber") Integer pageNumber,
			@Named("pageSize") Integer pageSize, @Named("idPolla") int idPolla,
			@Named("idMatch") int idMatch) throws Exception {

		MsgGetResulstMatchResponse msgResponse = new MsgGetResulstMatchResponse();

		try {

			ContextResponseDTO contextResponse = UtilContext
					.getFillContextResponseDTOBasic(idTransaction);
			msgResponse.setContextResponse(contextResponse);

			LMatch objLMatch = new LMatch();

			List<ResultMatch> lstResultMatch = objLMatch.getResulstMatch(
					idPolla, idMatch, pageNumber, pageSize);

			ResultMatchTransform objMatchTransform = new ResultMatchTransform();

			msgResponse.setLstResultMatchDTO(objMatchTransform
					.transformListDTO(lstResultMatch));

		} catch (Exception e) {			
			msgResponse.getContextResponse().setTransactionState(false);
			Error.SendError(e.getMessage());
			throw e;
		}

		return msgResponse;

	}

	@ApiMethod(name = "updateResultMatchOriginal", path = "updateResultMatchOriginal", httpMethod = HttpMethod.PUT)
	public MsgUpdateResultMatchOriginalResponse updateResultMatchOriginal(
			MsgUpdateResultMatchOriginalRequest request) throws Exception {

		MsgUpdateResultMatchOriginalResponse msgResponse = new MsgUpdateResultMatchOriginalResponse();

		try {

			ContextResponseDTO contextResponse = UtilContext
					.getFillContextResponseDTOBasic(request
							.getContextRequestDTO());
			msgResponse.setContextResponse(contextResponse);

			LMatch objLMatch = new LMatch();

			objLMatch.updateScoreMatchOriginal(request.getIdMatch(),
					request.getScoreTeamAOrg(), request.getScoreTeamBOrg());

		} catch (Exception e) {			
			msgResponse.getContextResponse().setTransactionState(false);
			Error.SendError(e.getMessage());
			throw e;
		}

		return msgResponse;

	}

	@ApiMethod(name = "getMatchsByRound", path = "getMatchsByRound", httpMethod = HttpMethod.GET)
	public MsgGetMatchsByRoundResponse getMatchsByRound(
			@Named("idTransaction") String idTransaction,
			@Named("user") String user,
			@Named("application") String application,
			@Named("pageNumber") Integer pageNumber,
			@Named("pageSize") Integer pageSize, @Named("idRound") int idRound)
			throws Exception {

		MsgGetMatchsByRoundResponse msgResponse = new MsgGetMatchsByRoundResponse();

		try {

			ContextResponseDTO contextResponse = UtilContext
					.getFillContextResponseDTOBasic(idTransaction);
			msgResponse.setContextResponse(contextResponse);

			LMatch objLMatch = new LMatch();

			List<Match> lstMatch = objLMatch.getMatchsByRound(idRound,
					pageNumber, pageSize);

			MatchTransform objMatchTransform = new MatchTransform();

			msgResponse.setLstMatchDTO(objMatchTransform
					.transformListDTO(lstMatch));

		} catch (Exception e) {			
			msgResponse.getContextResponse().setTransactionState(false);
			Error.SendError(e.getMessage());
			throw e;
		}

		return msgResponse;

	}

}
