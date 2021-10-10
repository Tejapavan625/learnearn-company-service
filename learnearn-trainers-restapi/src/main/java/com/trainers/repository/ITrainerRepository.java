package com.trainers.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.stereotype.Repository;

import com.trainers.model.PostAvailability;
import com.trainers.model.PostStatus;
import com.trainers.model.Trainer;

@Repository
public interface ITrainerRepository extends JpaRepository<Trainer, Integer>{
	Trainer getById(int trainerId);

	List<Trainer> findByTrainerAvailability(PostAvailability availability);

	List<Trainer> findByTrainerName(String TrainerName);

	List<Trainer> findByStartDate(LocalDateTime startDate);

	
	@Query("from Trainer t inner join t.courseList cs where cs.courseName= ?1 and t.trainerName= ?2")
	List<Trainer> findByCourseNameAndTrainerName(String courseName, String trainerName);
	@Query("from Trainer t inner join t.courseList cs where cs.courseName= ?1 and t.availability= ?2")
	List<Trainer> findByCourseNameAndAvailability(String courseName, PostAvailability availability);
	@Query("from Trainer t inner join t.courseList cs where cs.owner= ?1 and t.trainerName= ?2")
	List<Trainer> findByOwnerAndTrainerName(String courseOwner, String trainerName);
	@Query("from Trainer t inner join t.courseList cs where cs.startDate= ?1 and t.availability= ?2")
	List<Trainer>  findByCourseStartDateAndAvailability(LocalDateTime CourseStartDate,
			PostAvailability availability);
	@Query("from Trainer t inner join t.courseList cs where cs.status= ?1 and t.trainerName= ?2")
	List<Trainer> findByCourseStatusAndTrainerName(PostStatus status, String trainerName);
	@Query("from Trainer t inner join t.courseList cs where cs.status= ?1 and t.trainerName= ?2")
	List<Trainer> findByCourseStatusAnd(PostStatus status, String trainerName);

}
