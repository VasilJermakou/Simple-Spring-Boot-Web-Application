package com.vaer.springboot.thymeleafdemo.service;

import java.util.List;
import com.vaer.springboot.thymeleafdemo.entity.Employee;

public interface EmployeeService {
	
	List<Employee> findAll();
	Employee findById(int theId);
	void save(Employee theEmployee);
	void delete(int theId);

}
