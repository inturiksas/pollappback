package us.pollapp.inturik.transformDTO;

import us.pollapp.inturik.DTO.PollaDTO;
import us.pollapp.inturik.model.Pollas;
import us.pollapp.inturik.transformDTO.Utils.Transformer;

public class PollaTransform extends Transformer<PollaDTO, Pollas> {

	@Override
	public PollaDTO transformDTO(Pollas polla) {

		PollaDTO pollaDTO = new PollaDTO();

		if (polla != null) {

			pollaDTO.setId(polla.getId());
			pollaDTO.setName(polla.getNombre());
			pollaDTO.setCreatedDate(polla.getCreatedDate());
			pollaDTO.setIdUserAdmin(polla.getIdUserAdmin() == null ? 0 : polla
					.getIdUserAdmin());
		}

		return pollaDTO;

	}

	@Override
	public Pollas transformModel(PollaDTO dto) {
		return null;
	}
}
