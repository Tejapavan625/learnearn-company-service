package com.learnearn.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learnearn.model.Company;
import com.learnearn.model.PostPriority;
import com.learnearn.model.PostStatus;
import com.learnearn.service.ICompanyService;

@RestController
@RequestMapping("/company-service")
public class CompanyController {
	@Autowired 
	ICompanyService companyService;
	
	@GetMapping("/company")
	public List<Company> getAll(){
		return companyService.getAll();
		
	}
	
	@GetMapping("company/companyId/{companyId}")
	public Company getById(@PathVariable("companyId") int companyId) {
		return companyService.getById(companyId);
	}
		
	@PostMapping("/company")
	public String addCompany(@RequestBody Company company) {
	 companyService.addCompany(company);
		return "added Successfully";
	}

    @PutMapping("/company")
	String updateCompany(@RequestBody Company company) {
    	companyService.updateCompany(company);
		return "Updated Succesfully";
    }
    
	@DeleteMapping("/company/{companyId}")
	String deleteCompany(@PathVariable("companyId") int companyId) {
		companyService.deleteCompany(companyId);
		return "Deleted Succesfully";
	}


	@GetMapping("/company/companyName/{companyName}")
	List<Company> getByCompanyName(@PathVariable("companyName") String companyName){
		return companyService.getByCompanyName(companyName);
	}
	@GetMapping("/company/owner/{owner}")
	public Company getByOwner(@PathVariable("owner") String  owner) {
		return companyService.getByOwner(owner);
	}
	
	@GetMapping("/company/startDate/{startDate}/endDate/{endDate}")
	List<Company> getByStartDateAndEndDate(@PathVariable("startDate")String startDate,@PathVariable("endDate") String endDate){
		return companyService.getByStartDateAndEndDate(LocalDateTime.parse(startDate),LocalDateTime.parse(endDate));
	}
	
	@GetMapping("/company/priority/{priority}")
	List<Company> getByPriority(@PathVariable("priority")PostPriority priority){
		return companyService.getByPriority(priority);
	}
	@GetMapping("/company/status/{status}")
	List<Company> getByStatus(@PathVariable("status")PostStatus status){
		return companyService.getByStatus(status);
	}
	@GetMapping("/company/batchName/{batchName}/companyName/{companyName}")
	List<Company> getByBatchNameAndCompanyName(@PathVariable String batchName,@PathVariable String companyName){
	return companyService.getByBatchNameAndCompanyName(batchName, companyName);
	}
	@GetMapping("/company/batchName/{batchName}/owner/{owner}")
	List<Company> getByBatchNameAndCompanyOwner(@PathVariable String batchName,@PathVariable String owner){
		return companyService.getByBatchNameAndCompanyOwner(batchName, owner);
	}
	@GetMapping("/company/batchOwner/{batchOwner}/priority/{priority}")
	List<Company> getByBatchOwnerAndCompanyPriority(@PathVariable String batchName,@PathVariable PostPriority priority ){
		return companyService.getByBatchOwnerAndCompanyPriority(batchName, priority);
	}
	@GetMapping("/company/batchOwner/{batchOwner}/owner/{owner}")
	List<Company> getByBatchOwnerAndCompanyOwner(@PathVariable String batchOwner,@PathVariable String owner){
		return companyService.getByBatchOwnerAndCompanyOwner(batchOwner, owner);
	}
	@GetMapping("/company/batchStartDate/{batchStartDate}/companyName/{companyName}")
	List<Company> getByBatchStartDateAndCompanyName(@PathVariable LocalDateTime batchStartDate,@PathVariable String companyName){
		return companyService.getByBatchStartDateAndCompanyName(batchStartDate, companyName);
	}
	@GetMapping("/company/courseName/{courseName}/companyName/{companyName}")
	List<Company> getByCourseNameAndCompanyName(@PathVariable String courseName, @PathVariable  String companyName){
		return companyService.getByCourseNameAndCompanyName(courseName, companyName);
	}
	@GetMapping("/company/status/{status}/companyName/{companyName}")
	List<Company> getByCourseStatusAndCompanyName(@PathVariable PostStatus status,@PathVariable String companyName){
		return companyService.getByCourseStatusAndCompanyName(status, companyName);
}
	@GetMapping("/company/courseStartDate/{courseStartDate}/status/{status}")
    List<Company> getByCourseStartDateAndCompanyStatus(@PathVariable LocalDateTime courseStartDate,@PathVariable String status){
    return companyService.getByCourseStartDateAndCompanyStatus(courseStartDate, status);

	
}
}
