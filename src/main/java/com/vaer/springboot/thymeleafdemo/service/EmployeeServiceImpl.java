package com.vaer.springboot.thymeleafdemo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vaer.springboot.thymeleafdemo.dao.EmployeeRepository;
import com.vaer.springboot.thymeleafdemo.entity.Employee;
import com.vaer.springboot.thymeleafdemo.exception.EmployeeNotFoundException;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	/* class fields */
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> findAll() {
		return this.employeeRepository.findByOrderByLastNameAsc();
	}

	@Override
	public Employee findById(int theId) {
		Optional<Employee> optional = this.employeeRepository.findById(theId);
		
		Employee theEmployee = null;
		if(optional.isPresent()) {
			theEmployee = optional.get();
		}else {
			throw new EmployeeNotFoundException("Employee not found, id: " + theId);
		}
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		this.employeeRepository.save(theEmployee);
	}

	@Override
	public void delete(int theId) {
		this.employeeRepository.deleteById(theId);

	}

}
