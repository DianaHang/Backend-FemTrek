package com.femtrek.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.femtrek.models.Quizz;
import com.femtrek.services.QuizzService;

@RestController
@RequestMapping("/api/quizz")
public class QuizzController {
	@Autowired
	private QuizzService quizzService;
	
	//GET 
	@GetMapping
	public List<Quizz> getAllquizz(){
		return quizzService.findAllQuizzes();
	}
	
			@GetMapping("{id}")
			public ResponseEntity<Quizz> getquizzById(@PathVariable Long id){
				return quizzService.findQuizzById(id)
						.map(ResponseEntity::ok)
						.orElse(ResponseEntity.notFound().build());
			}
			
			// POST
			@PostMapping
			public Quizz createquizz (@RequestBody Quizz quizz) {
				return quizzService.saveQuizz(quizz);
			}

			
			//PUT
			
			@PutMapping("/quizzs/{id}")
		    public Quizz updatequizz(@PathVariable Long id, @RequestBody Quizz quizzDetails) {
		        return quizzService.updateQuizz(id, quizzDetails);
		    }

			
			// DELETE
			@DeleteMapping("{id}")
			public ResponseEntity<Void> deletequizz(@PathVariable Long id){
				return quizzService.findQuizzById(id)
						.map(quizz -> { quizzService.deletequizzById(id); return ResponseEntity.ok().<Void>build();})
						.orElse(ResponseEntity.notFound().build());
			}

}
