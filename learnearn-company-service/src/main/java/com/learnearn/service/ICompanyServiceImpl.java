package com.learnearn.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.learnearn.model.Batch;
import com.learnearn.model.Company;
import com.learnearn.model.PostPriority;
import com.learnearn.model.PostStatus;
import com.learnearn.repository.ICompanyRepository;

@Service
public class ICompanyServiceImpl implements ICompanyService {

	@Autowired
	ICompanyRepository companyRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	public static final String BASEURL="http://localhost:8082/batch-service/batches";
	List<Batch> bacthList= new ArrayList<>();

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

	@Override
	public Batch addBatch(Batch batch) {
		String url=BASEURL+"/batches" ;
		return null;
	}

	@Override
	public void updateBatch(Batch batch) {
		
	}

	@Override
	public void deleteBatch(int batchId) {
		
	}

	@Override
	public List<Batch> getAllBatch() {
		String url=BASEURL+"/batches" ;
		List<Batch> batchList = restTemplate.getForObject(url, List.class);
		return batchList;
	}

	@Override
	public Batch getByBatchId(int batchId) {
		String url=BASEURL+"/batchId/"+batchId;
		Batch batch=restTemplate.getForObject(url,Batch.class);
		return batch;
	}

	@Override
	public Batch getByBatchName(String batchName) {
		String url=BASEURL+"/batchName/"+batchName;
		Batch batch=restTemplate.getForObject(url,Batch.class);
		return batch;
	}

	@Override
	public List<Batch> getBybatchOwner(String owner) {
		String url=BASEURL+"/owner/"+owner;
		List<Batch> batchList = restTemplate.getForObject(url, List.class);
		return batchList;
	}

	@Override
	public List<Batch> getBybatchStartDateAndEndDate(LocalDateTime startDate, LocalDateTime endDate) {
		String url=BASEURL+"/startDate/"+startDate+"/endDate/"+endDate;
		List<Batch> batchList = restTemplate.getForObject(url, List.class);
		return bacthList;
	}

	@Override
	public List<Batch> getBybacthStatus(PostStatus status) {
		String url=BASEURL+"/status/"+status;
		List<Batch> batchList = restTemplate.getForObject(url, List.class);

		return bacthList;
	}

	@Override
	public List<Batch> getBybatchPriority(PostPriority priority) {
		String url=BASEURL+"/priority/"+priority;
		List<Batch> batchList = restTemplate.getForObject(url, List.class);

		return batchList;
	}

	@Override
	public List<Batch> getByBatchNameCourseName(String batchName) {
		String url=BASEURL+"/batchName/"+batchName;
		List<Batch> batchList = restTemplate.getForObject(url, List.class);
		return batchList;
	}

	@Override
	public List<Batch> getByBatchNameCourseStatus(String batchName, PostStatus status) {
		String url=BASEURL+"/batchName/"+batchName+"/status/"+status;
		List<Batch> batchList = restTemplate.getForObject(url, List.class);
		return batchList;
	}

	@Override
	public List<Batch> getByBatchNameCoursePriority(String batchName, PostPriority priority) {
		String url=BASEURL+"/batchName/"+batchName+"/priority/"+priority;
		List<Batch> batchList = restTemplate.getForObject(url, List.class);
		return batchList;
	}

	@Override
	public List<Batch> getByBatchNameCourseStartDate(String batchName, LocalDateTime startDate) {
		String url=BASEURL+"/batchName/"+batchName+"/startDate/"+startDate;
		List<Batch> batchList = restTemplate.getForObject(url, List.class);
		return batchList;
	}

	@Override
	public List<Batch> getByBatchNameCourseOwner(String batchName, String owner) {
		
		String url=BASEURL+"/batchName/"+batchName+"/owner/"+owner;
		List<Batch> batchList = restTemplate.getForObject(url, List.class);
		return batchList;
	}
	


}
