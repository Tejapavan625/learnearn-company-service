package com.trainers.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
public class Company {

	private Integer comapanyId;

	private String companyName;
	private String owner;
	private LocalDate startDate;
	private LocalDate endDate;

	@Enumerated(EnumType.STRING)
	@Column(length = 9)
	private PostStatus status;

	@Enumerated(EnumType.STRING)
	@Column(length = 9)
	private PostPriority priority;
	@OneToMany
	private Set<Batch> batchList;// one to many
	@OneToMany
	private Set<Course> courseList;// one to many

}
