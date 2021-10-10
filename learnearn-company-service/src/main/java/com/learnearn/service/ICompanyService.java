package com.learnearn.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.learnearn.model.Company;
import com.learnearn.model.PostPriority;
import com.learnearn.model.PostStatus;

public interface ICompanyService {

	Company addCompany(Company company);

	void updateCompany(Company company);

	void deleteCompany(int companyId);

	Company getById(int companyId);

	List<Company> getAll();

	List<Company> getByCompanyName(String companyName);

	Company getByOwner(String owner);

	List<Company> getByStartDateAndEndDate(LocalDateTime startDate, LocalDateTime endDate);

	List<Company> getByPriority(PostPriority priority);

	List<Company> getByStatus(PostStatus status);

	List<Company> getByBatchNameAndCompanyName(String batchName, String companyName);

	List<Company> getByBatchNameAndCompanyOwner(String batchName, String owner);

	List<Company> getByBatchOwnerAndCompanyPriority(String batchName, PostPriority priority);

	List<Company> getByBatchOwnerAndCompanyOwner(String batchOwner, String owner);

	List<Company> getByBatchStartDateAndCompanyName(LocalDateTime startDate, String companyName);

	List<Company> getByCourseNameAndCompanyName(String courseName, String companyName);

	List<Company> getByCourseStatusAndCompanyName(PostStatus status, String companyName);

	List<Company> getByCourseStartDateAndCompanyStatus(LocalDateTime courseStartDate, String status);

}
