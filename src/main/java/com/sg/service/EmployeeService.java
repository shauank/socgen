package com.sg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sg.domain.Employee;
import com.sg.exception.EmployeeNotFoundException;
import com.sg.repository.EmployeeRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * @author shpatel
 *  
 * Service class for Employee
 */
@Service
@Slf4j
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	/**
	 * @param employee Create employee
	 */
	public Employee createEmployee(Employee employee) {
		log.info("Creating employee");
		return employeeRepository.save(employee);
	}
	
	/**
	 * @return List of employee
	 */
	public List<Employee> findAll(){
		log.info("Retrieving all employees");
		List<Employee> employeeList = employeeRepository.findAllByOrderByFirstNameAsc();
		if(employeeList.isEmpty()) {
			throw new EmployeeNotFoundException("Could not found employee");
		}
		return employeeList;
	}
}
