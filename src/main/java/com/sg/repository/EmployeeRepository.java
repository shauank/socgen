package com.sg.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sg.domain.Employee;

/**
 * @author shpatel
 *
 * Repository for Employee
 */
@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>{

}
