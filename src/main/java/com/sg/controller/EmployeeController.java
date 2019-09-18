package com.sg.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sg.dto.EmployeeDTO;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
	
	/**
	 * @param employeeDTO
	 * 
	 * Create employee object from @param employeeDTO 
	 */
	@PostMapping
	public ResponseEntity<Object> createEmployee(@RequestBody EmployeeDTO employeeDTO) {
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	/**
	 * @return List of all employee
	 */
	@GetMapping
	public List<EmployeeDTO> findAll(){
		return null;
	}

}
