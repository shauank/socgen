package com.sg.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sg.common.serializer.DateDeSerializer;
import com.sg.domain.Gender;

import lombok.Getter;
import lombok.Setter;

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

	@JsonDeserialize(using = DateDeSerializer.class)
	private LocalDate dateOfBirth;

	private String department;

}
