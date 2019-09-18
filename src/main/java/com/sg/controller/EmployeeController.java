package com.sg.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sg.domain.Employee;
import com.sg.dto.EmployeeDTO;
import com.sg.service.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/emp")
@Api(tags = "Employee Controller")
@Slf4j
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	/**
	 * @return List of all employee
	 */
	@GetMapping
	@ApiOperation(value = "Retrieve all employee in ascending order of firstName", response = ResponseEntity.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Find all employee"),
			@ApiResponse(code = 404, message = "Could not found employee") })
	public List<EmployeeDTO> findAll() {
		log.info("Retrieving all employees");
		return employeeService.findAll().stream().map(employee -> {
			EmployeeDTO employeeDTO = new EmployeeDTO();
			BeanUtils.copyProperties(employee, employeeDTO);
			return employeeDTO;
		}).collect(Collectors.toList());
	}

	/**
	 * @param employeeDTO
	 * 
	 * Create employee object from @param employeeDTO
	 */
	@PostMapping
	@ApiOperation(value = "Create an employee", response = ResponseEntity.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Created employee") })
	public ResponseEntity<Object> createEmployee(
			@ApiParam(value = "Employee object store in database", required = false) @RequestBody EmployeeDTO employeeDTO) {
		Employee employee = new Employee();
		BeanUtils.copyProperties(employeeDTO, employee);
		employee = employeeService.createEmployee(employee);
		log.info("Creating employee");
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

}
