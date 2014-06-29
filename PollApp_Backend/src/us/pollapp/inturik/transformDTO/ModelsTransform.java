package us.pollapp.inturik.transformDTO;

import java.util.Set;

import us.pollapp.inturik.DTO.ModelDTO;
import us.pollapp.inturik.DTO.PictureModelDTO;
import us.pollapp.inturik.model.Model;
import us.pollapp.inturik.model.PictureModel;
import us.pollapp.inturik.transformDTO.Utils.Transformer;

public class ModelsTransform extends Transformer<ModelDTO, Model> {

	@Override
	public ModelDTO transformDTO(Model model) {

		ModelDTO modelDTO = new ModelDTO();

		if (model != null) {

			modelDTO.setId(model.getId());
			modelDTO.setName(model.getName());
			modelDTO.setScore(model.getScore());
			modelDTO.setNameCountry(model.getCountry().getName());

			PictureModelDTO[] arrPicturesModels = new PictureModelDTO[model
					.getPictureModels().size()];

			Set<PictureModel> lstPictureModels = model.getPictureModels();
			PictureModelDTO objPictureModelDTO;

			int index = 0;

			for (PictureModel pictureModel : lstPictureModels) {

				objPictureModelDTO = new PictureModelDTO();

				objPictureModelDTO.setId(pictureModel.getId());
				objPictureModelDTO.setActive(pictureModel.getPicture()
						.getActive());
				objPictureModelDTO.setMain(pictureModel.getMain());
				objPictureModelDTO.setPicture(pictureModel.getPicture()
						.getPicture());

				arrPicturesModels[index] = objPictureModelDTO;

				index++;

			}
			
			modelDTO.setPicturesModel(arrPicturesModels);

		}

		return modelDTO;

	}

	@Override
	public Model transformModel(ModelDTO dto) {
		return null;
	}

}
