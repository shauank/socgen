package com.sg.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author shpatel
 * Domain class for Employee
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode
public class Employee {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String firstName;
	
	private String lastName;
	
	private Gender gender;
	
	private LocalDate dateOfBirth;
	
	private String department;
	

}
