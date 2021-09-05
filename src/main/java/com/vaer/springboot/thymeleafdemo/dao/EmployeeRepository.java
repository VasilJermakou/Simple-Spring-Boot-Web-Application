package com.vaer.springboot.thymeleafdemo.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.vaer.springboot.thymeleafdemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	/* this method allows to have sorted by lastName data */
	public List<Employee> findByOrderByLastNameAsc();
}
