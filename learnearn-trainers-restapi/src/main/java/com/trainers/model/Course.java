package com.trainers.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
public class Course {
	
	private Integer courseId;

	private String courseName;
	private String owner;
	private LocalDate startDate;
	private LocalDate endDate;
	
	@Enumerated(EnumType.STRING)
	@Column(length=9)
	private PostStatus status;
	
	@Enumerated(EnumType.STRING)
	@Column(length=9)
	private PostPriority priority;
	
	@OneToMany
	private Set<Trainer> trainerList;
	@ManyToOne
	private Company company;
	
	
	
	

}
