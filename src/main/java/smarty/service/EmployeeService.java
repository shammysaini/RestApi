package smarty.service;

import java.util.List;

import org.springframework.stereotype.Service;

import smarty.dto.CommonResponse;
import smarty.dto.EmployeeFetchResponse;
import smarty.dto.EmployeeRequest;
import smarty.dto.EmployeeResponse;


public interface EmployeeService {
	
	CommonResponse<EmployeeResponse> saveEmployee(EmployeeRequest employeeRequest);
	List<EmployeeFetchResponse> fetchAll();
	
}
