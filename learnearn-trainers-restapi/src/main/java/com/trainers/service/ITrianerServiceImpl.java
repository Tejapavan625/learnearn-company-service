package com.trainers.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trainers.model.PostAvailability;
import com.trainers.model.PostStatus;
import com.trainers.model.Trainer;
import com.trainers.repository.ITrainerRepository;

@Service
public class ITrianerServiceImpl implements ITrainerService{
	
	@Autowired
	ITrainerRepository trainerRepository;

	@Override
	public Trainer addTrainer(Trainer trainer) {
		return trainerRepository.save(trainer);
	}

	@Override
	public void updateTrainer(Trainer trainer) {
		 trainerRepository.save(trainer);
	}

	@Override
	public void deleteTrainer(int trainerId) {
		trainerRepository.deleteById(trainerId);
	}

	@Override
	public List<Trainer> getAll() {
		// TODO Auto-generated method stub
		return trainerRepository.findAll();
	}

	@Override
	public Trainer getById(int trainerId) {
		// TODO Auto-generated method stub
		return trainerRepository.findById(trainerId).get();
	}

	@Override
	public List<Trainer> getByTrainerAvailability(PostAvailability availability) {
		// TODO Auto-generated method stub
		return trainerRepository.findByTrainerAvailability(availability);
	}

	@Override
	public List<Trainer> getByTrainerName(String TrainerName) {
		// TODO Auto-generated method stub
		return trainerRepository.findByTrainerName(TrainerName);
	}


	@Override
	public List<Trainer> getByCourseNameAndTrainerName(String courseName, String trainerName) {
		// TODO Auto-generated method stub
		return trainerRepository.findByCourseNameAndTrainerName(courseName, trainerName);
	}

	@Override
	public List<Trainer> getByCourseNameAndAvailability(String courseName, PostAvailability availability) {
		// TODO Auto-generated method stub
		return trainerRepository.findByCourseNameAndAvailability(courseName, availability);
	}

	@Override
	public List<Trainer> getByOwnerAndTrainerName(String courseOwner, String trainerName) {
		// TODO Auto-generated method stub
		return trainerRepository.findByOwnerAndTrainerName(courseOwner, trainerName);
	}

	@Override
	public List<Trainer> getByCourseStartDateAndAvailability(LocalDateTime CourseStartDate,
			PostAvailability availability) {
		// TODO Auto-generated method stub
		return trainerRepository.findByCourseStartDateAndAvailability(CourseStartDate, availability);
	}

	@Override
	public List<Trainer> getByCourseStatusAndTrainerName(PostStatus status, String trainerName) {
		// TODO Auto-generated method stub
		return trainerRepository.findByOwnerAndTrainerName(trainerName, trainerName);
	}

	

}
