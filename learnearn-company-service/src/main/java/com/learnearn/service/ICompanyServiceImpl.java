package com.learnearn.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learnearn.model.Company;
import com.learnearn.model.PostPriority;
import com.learnearn.model.PostStatus;
import com.learnearn.repository.ICompanyRepository;

@Service
public class ICompanyServiceImpl implements ICompanyService {

	@Autowired
	ICompanyRepository companyRepository;

	@Override
	public Company addCompany(Company company) {
		return companyRepository.save(company);
	}

	@Override
	public void updateCompany(Company company) {
		companyRepository.save(company);

	}

	@Override
	public void deleteCompany(int companyId) {
		companyRepository.deleteById(companyId);
	}
	@Override
	public Company getByOwner(String owner) {
		// TODO Auto-generated method stub
		return  companyRepository.findByOwner(owner);
	}

	@Override
	public Company getById(int companyId) {
		return companyRepository.findById(companyId).get();
	}

	@Override
	public List<Company> getAll() {
		return companyRepository.findAll();
	}

	@Override
	public List<Company> getByCompanyName(String companyName) {
		// TODO Auto-generated method stub
		return companyRepository.findByCompanyName(companyName);
	}

	

	@Override
	public List<Company> getByStartDateAndEndDate(LocalDateTime startDate,LocalDateTime endDate) {
		return companyRepository.findByStartDateAndEndDate(startDate, endDate);
	}

	@Override
	public List<Company> getByPriority(PostPriority priority) {
		return companyRepository.findByPriority(priority);
	}

	@Override
	public List<Company> getByStatus(PostStatus status) {
		return companyRepository.findByStatus(status);
	}

	

	@Override
	public List<Company> getByBatchNameAndCompanyName(String batchName, String companyName) {
		// TODO Auto-generated method stub
		return companyRepository.findByBatchNameAndCompanyName(batchName, companyName);
	}
//
	@Override
	public List<Company> getByBatchNameAndCompanyOwner(String batchName, String owner) {
		// TODO Auto-generated method stub
	
		return companyRepository.findByBatchNameAndCompanyOwner(batchName, owner);
	}

	@Override
	public List<Company> getByBatchOwnerAndCompanyPriority(String batchName, PostPriority priority) {
		// TODO Auto-generated method stub
		return companyRepository.findByBatchOwnerAndCompanyPriority(batchName, priority);
	}

@Override
	public List<Company> getByCourseNameAndCompanyName(String courseName, String companyName) {
		// TODO Auto-generated method stub
		return companyRepository.findByCourseNameAndCompanyName(courseName, companyName);
	}

	@Override
	public List<Company> getByCourseStatusAndCompanyName(PostStatus status, String companyName) {
		// TODO Auto-generated method stub
		return companyRepository.findByCourseStatusAndCompanyName(status, companyName);
	}

	@Override
	public List<Company> getByBatchOwnerAndCompanyOwner(String batchOwner, String owner) {
		// TODO Auto-generated method stub
		return companyRepository.findByBatchOwnerAndCompanyOwner(batchOwner,owner) ;
	}

	@Override
	public List<Company> getByBatchStartDateAndCompanyName(LocalDateTime startDate, String companyName) {
		// TODO Auto-generated method stub
	return companyRepository.findByBatchNameAndCompanyName(companyName, companyName);
	}

	@Override
	public List<Company> getByCourseStartDateAndCompanyStatus(LocalDateTime courseStartDate, String status) {
		// TODO Auto-generated method stub
		return companyRepository.findByCourseStartDateAndCompanyStatus(courseStartDate, status);
	}




}
