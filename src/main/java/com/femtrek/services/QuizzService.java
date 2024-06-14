package com.femtrek.services;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.femtrek.models.Quizz;
import com.femtrek.repositories.QuizzRepository;


@Service
public class QuizzService {
	@Autowired
	private QuizzRepository quizzRepository;
	
	//GET			
	public List<Quizz> findAllQuizzes(){
		return quizzRepository.findAll();
	}
		
			public Optional<Quizz> findQuizzById(Long id){
				return quizzRepository.findById(id);
			}
			
			//POST
			public Quizz saveQuizz (Quizz quizz) {
				return quizzRepository.save(quizz);
			}

			// PUT
		    public Quizz updateQuizz(Long id, Quizz quizzDetails) {
		        Optional<Quizz> optionalQuizz = quizzRepository.findById(id);
		        if (optionalQuizz.isPresent()) {
		            Quizz quizzToUpdate = optionalQuizz.get();
		            quizzToUpdate.setTravel_excitement(quizzDetails.getTravel_excitement());
		            quizzToUpdate.setFavorite_season(quizzDetails.getFavorite_season());
		            quizzToUpdate.setTravel_enjoy(quizzDetails.getTravel_enjoy());
		            quizzToUpdate.setTravel_preference(quizzDetails.getTravel_preference());
		            quizzToUpdate.setLatinCountriesOfInterest(quizzDetails.getLatinCountriesOfInterest());
		            quizzToUpdate.setTravel_style(quizzDetails.getTravel_style());

		            
		            return quizzRepository.save(quizzToUpdate);
		        } else {
		            throw new RuntimeException("post not found with id " + id);
		        }
		    }
			
			//DELETE
			public void deletequizzById(Long id) {
				quizzRepository.deleteById(id);
			}

}
