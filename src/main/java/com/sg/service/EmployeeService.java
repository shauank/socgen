package com.sg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sg.domain.Employee;
import com.sg.repository.EmployeeRepository;

/**
 * @author shpatel
 *  
 * Service class for Employee
 */
@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	/**
	 * @param employee Create employee
	 */
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	/**
	 * @return List of employee
	 */
	public List<Employee> findAll(){
		return employeeRepository.findAllByOrderByFirstNameAsc();
	}

}
