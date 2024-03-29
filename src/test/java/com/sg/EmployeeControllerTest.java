package com.sg;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.time.LocalDate;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.sg.domain.Employee;
import com.sg.domain.Gender;
import com.sg.exception.EmployeeNotFoundException;
import com.sg.service.EmployeeService;

@RunWith(SpringRunner.class)
@ComponentScan("com.*")
@EnableWebMvc
@WebAppConfiguration
public class EmployeeControllerTest {
	
    @Autowired
    private EmployeeService employeeService;

	@Test
	public void testCreateEmployee() throws Exception{
		
		LocalDate currentDate = LocalDate.now();
		
		Employee e = new Employee();
		e.setFirstName("firstName");
		e.setGender(Gender.MALE);
		e.setLastName("lastname");
		e.setDateOfBirth(currentDate);
		
		
		employeeService.createEmployee(e);
		
		List<Employee> employees = employeeService.findAll();
		
		assertThat(employees.size(), is(1));
		
		assertThat(employees.get(0).getFirstName(), is("firstName"));
		assertThat(employees.get(0).getGender(), is(Gender.MALE));
		assertThat(employees.get(0).getDateOfBirth(), is(currentDate));
		assertThat(employees.get(0).getLastName(), is("lastname"));
	}
	
	@Test(expected = EmployeeNotFoundException.class)
	public void testCreateEmployeeValidationFail() throws Exception{
		employeeService.findAll();
	}
	
	@Test
	public void testFindAll() {
		
		this.createEmployeeWithFirstName("baaaa");
		this.createEmployeeWithFirstName("xaaaa");
		this.createEmployeeWithFirstName("zaaaa");
		this.createEmployeeWithFirstName("daaaa");
		this.createEmployeeWithFirstName("aaaaa");
		
		
		List<Employee> employees = employeeService.findAll();
		
		assertThat(employees.size(), is(5));
		
		assertThat(employees.get(0).getFirstName(), is("aaaaa"));
		assertThat(employees.get(1).getFirstName(), is("baaaa"));
		assertThat(employees.get(2).getFirstName(), is("daaaa"));
		assertThat(employees.get(3).getFirstName(), is("xaaaa"));
		assertThat(employees.get(4).getFirstName(), is("zaaaa"));
	}
	
	private void createEmployeeWithFirstName(String firstName) {
		Employee e = new Employee();
		e.setFirstName(firstName);
		employeeService.createEmployee(e);
	}

}
