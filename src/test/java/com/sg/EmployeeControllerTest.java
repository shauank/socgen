package com.sg;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sg.controller.EmployeeController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeControllerTest {
	
	@InjectMocks
	private EmployeeController employeeController;

	@Test
	public void testCreateEmployee() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testFindAll() {
		fail("Not yet implemented");
	}

}
