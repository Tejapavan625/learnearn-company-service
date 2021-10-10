package com.learnearn.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Trainer {
	
	private String trainerName;
	@Id
	@GeneratedValue(generator="trainer_gen",strategy=GenerationType.AUTO)
	@SequenceGenerator(name="trainer_gen",sequenceName = "trainer_seq",initialValue = 1,allocationSize = 1)
	private Integer trainerId;
	private LocalDate startDate;
	private LocalDate endDate;
	
	
	
	@Enumerated(EnumType.STRING)
	@Column(length=9)
	private PostAvailabilty availability;
	
	@OneToOne
	@JoinColumn(name="course_id")
	private Course course;
	
	
	
	
	
	
	

}
