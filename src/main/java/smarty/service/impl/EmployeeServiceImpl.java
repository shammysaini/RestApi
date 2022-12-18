package smarty.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import smarty.dto.CommonResponse;
import smarty.dto.EmployeeFetchResponse;
import smarty.dto.EmployeeRequest;
import smarty.dto.EmployeeResponse;
import smarty.model.Employee;
import smarty.repository.EmployeeRepository;
import smarty.service.EmployeeService;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public CommonResponse<EmployeeResponse> saveEmployee(EmployeeRequest employeeRequest) {
		log.info("Enter in saveEmployee method present in EmployeeServiceImpl class  at line number 20");
		Employee emp;
		CommonResponse<EmployeeResponse> commonResponse = new CommonResponse<EmployeeResponse>();
		try {
			emp = new Employee();
			EmployeeResponse employeeResponse = new EmployeeResponse();
			emp.setFirstName(employeeRequest.getFirstName());
			emp.setLastName(employeeRequest.getLastName());
			emp.setEmail(employeeRequest.getEmail());
			emp = employeeRepository.save(emp);
			employeeRequest.setId(emp.getId());
			employeeResponse.setEmployeeRequest(employeeRequest);
			commonResponse.setResult(true);
			commonResponse.setMessage("Record save successfully");
			commonResponse.setStatusCode(HttpStatus.OK.value());
			commonResponse.setData(employeeResponse);

			return commonResponse;

		} catch (Exception e) {

			return commonResponse = null;

		}

	}

	@Override
	public List<EmployeeFetchResponse> fetchAll() {
		log.info("Enter in fetchAll method present in EmployeeServiceImpl class  at line number 52");
		List<EmployeeFetchResponse>listEmployeeFetchResponse = new ArrayList<>(); 
		
		
		try {
			List<Employee> listEmployee = 	employeeRepository.findAll();
			
		if(!listEmployee.isEmpty())
		{
			
			
			for(Employee ee : listEmployee)
			{
				EmployeeFetchResponse employeeFetchResponse = new EmployeeFetchResponse();
				employeeFetchResponse.setId(ee.getId());
				employeeFetchResponse.setFirstName(ee.getFirstName());
				employeeFetchResponse.setLastName(ee.getLastName());
				employeeFetchResponse.setEmail(ee.getEmail());
				listEmployeeFetchResponse.add(employeeFetchResponse);
				
			}
			
		}
		
		}catch(Exception e)
		{
			Collections.emptyList();
		}
		return listEmployeeFetchResponse;
	}

	

}
