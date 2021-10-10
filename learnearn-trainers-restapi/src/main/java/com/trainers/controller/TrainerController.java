package com.trainers.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trainers.model.PostAvailability;
import com.trainers.model.PostStatus;
import com.trainers.model.Trainer;
import com.trainers.service.ITrainerService;

@RestController
@RequestMapping("/trainer-service")
public class TrainerController {
	
	@Autowired
	ITrainerService trainerService;
	
	@PostMapping("/trainer")
	String addTrainer(Trainer trainer){
		 trainerService.addTrainer(trainer);
		 return "added successfully";
		}

	@PutMapping("/trainer")
	public String updateTrainer(Trainer trainer){
		 trainerService.updateTrainer(trainer);
		 return "Update Successfully";
	}
	

	@GetMapping("/trainer/trainerId/{trainerId}")
	void deleteTrainer(int trainerId){
		trainerService.deleteTrainer(trainerId);
	}

	@GetMapping("/trainer")
	List<Trainer> getAll(){
		return trainerService.getAll();
		
	}
	
	@GetMapping("/trainer/trainerId/{trainerId}")
	Trainer getById(int trainerId){
		return trainerService.getById(trainerId);
	}
	@GetMapping("/trainer/availability/{availability}")
	List<Trainer> getByTrainerAvailability(@PathVariable PostAvailability availability){
		return trainerService.getByTrainerAvailability(availability);
	}
	@GetMapping("/trainer/trainerName/{trainerName}")
	List<Trainer> getByTrainerName(@PathVariable String TrainerName){
		return trainerService.getByTrainerName(TrainerName);
	}
	
	@GetMapping("/trainer/courseName/{courseName}/trainerName/{trainerName}")
	List<Trainer> getByCourseNameAndTrainerName(String courseName, String trainerName){
		return trainerService.getByCourseNameAndTrainerName(courseName, trainerName);
	}
	@GetMapping("/trainer/courseName/{courseName}/availability/{availability}")
	List<Trainer> getByCourseNameAndAvailability(String courseName, PostAvailability availability){
		return trainerService.getByCourseNameAndAvailability(courseName, availability);
	}

	@GetMapping("/trainer/courseOwner/{courseOwner}/trainerName/{trainerName}")
	List<Trainer> getByOwnerAndTrainerName(@PathVariable String courseOwner, @PathVariable
			String trainerName){
		return trainerService.getByOwnerAndTrainerName(courseOwner, trainerName);
	}

	@GetMapping("/trainer/CourseStartDate/{CourseStartDate}/availability/{availability}")
	List<Trainer> getByCourseStartDateAndAvailability(@PathVariable String CourseStartDate,
			@PathVariable PostAvailability availability){
		return trainerService.getByCourseStartDateAndAvailability(LocalDateTime.parse(CourseStartDate),  availability);
	}
	@GetMapping("/trainer/status/{status}/trainerName/{trainerName}")
	List<Trainer> getByCourseStatusAndTrainerName(@PathVariable PostStatus status,@PathVariable  String trainerName){
		return trainerService.getByCourseStatusAndTrainerName(status, trainerName);
	}

}
