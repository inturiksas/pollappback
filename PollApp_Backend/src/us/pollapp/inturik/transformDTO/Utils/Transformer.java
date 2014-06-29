package us.pollapp.inturik.transformDTO.Utils;

import java.util.ArrayList;
import java.util.List;

public abstract class Transformer<DTO, Model> {

	public abstract DTO transformDTO(Model model);

	public abstract Model transformModel(DTO dto);

	public List<DTO> transformListDTO(List<Model> lstModel) {
		List<DTO> lstDTO = new ArrayList<>();

		if (lstModel != null) {

			for (Model model : lstModel) {
				lstDTO.add(transformDTO(model));
			}

		}

		return lstDTO;
	}

	public List<Model> transformListModel(List<DTO> lstDTO) {

		List<Model> lstModel = new ArrayList<>();

		if (lstDTO != null) {

			for (DTO dto : lstDTO) {
				lstModel.add(transformModel(dto));
			}

		}

		return lstModel;
	}

}
