package com.trainers.service;

import java.time.LocalDateTime;
import java.util.List;

import com.trainers.model.PostAvailability;
import com.trainers.model.PostStatus;
import com.trainers.model.Trainer;

public interface ITrainerService {
	Trainer addTrainer(Trainer trainer);

	void updateTrainer(Trainer trainer);

	void deleteTrainer(int trainerId);

	List<Trainer> getAll();

	Trainer getById(int trainerId);

	List<Trainer> getByTrainerAvailability(PostAvailability availability);

	List<Trainer> getByTrainerName(String TrainerName);

	List<Trainer> getByCourseNameAndTrainerName(String courseName, String trainerName);

	List<Trainer> getByCourseNameAndAvailability(String courseName, PostAvailability availability);

	List<Trainer> getByOwnerAndTrainerName(String courseOwner, String trainerName);

	List<Trainer> getByCourseStartDateAndAvailability(LocalDateTime CourseStartDate,
			PostAvailability availability);

	List<Trainer> getByCourseStatusAndTrainerName(PostStatus status, String trainerName);
	
	

}
