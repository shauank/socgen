package com.sg.dto;

import java.time.LocalDate;

import com.sg.domain.Gender;

import lombok.Setter;

import lombok.Getter;

/**
 * @author shpatel
 * 
 * DTO object for Employee
 */
@Getter
@Setter
public class EmployeeDTO {
	private String firstName;

	private String lastName;

	private Gender gender;

	private LocalDate dateOfBirth;

	private String department;

}
