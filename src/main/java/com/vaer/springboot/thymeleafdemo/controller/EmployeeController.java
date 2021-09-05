package com.vaer.springboot.thymeleafdemo.controller;

import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.vaer.springboot.thymeleafdemo.entity.Employee;
import com.vaer.springboot.thymeleafdemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	/**
	 * TYPE IN BROWSER:
	 * http://localhost:8080/employees/list
	 * */
	
	/* class fields */
	@Autowired
	private EmployeeService employeeService;
	
	private final Logger LOGGER = Logger.getLogger(this.getClass().getName());
	
	
	/* methods */
	@GetMapping("/list")
	public String getEmployees(Model theModel) {
		
		/** get list of employees from DB*/
		List<Employee> theEmployees = this.employeeService.findAll();
		this.LOGGER.info("get list of employees from DB");
		
		/** add employee list as model attribute*/
		theModel.addAttribute("employees", theEmployees);
		this.LOGGER.info("add employee list as model attribute");
		
		/** return list-employees html page*/
		this.LOGGER.info("return list-employees html page");
		return "list-employees";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		/** create employee object*/
		Employee theEmployee = new Employee();
		this.LOGGER.info("create employee object");
		
		/** add employee model attribute*/
		theModel.addAttribute("employee", theEmployee);
		this.LOGGER.info("add employee model attribute");
		
		/** return employee-form html page*/
		this.LOGGER.info("return employee-form html page");
		return "employee-form";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("employee") Employee theEmployee) {
		
		/** save employee to DB*/
		this.employeeService.save(theEmployee);
		this.LOGGER.info("save employee to DB");
		
		this.LOGGER.info("redirect to /employees/list controller");
		return "redirect:/employees/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel) {
		
		/** get employee by id from DB*/
		Employee theEmployee = this.employeeService.findById(theId);
		this.LOGGER.info("get employee by id from DB");
		
		/** add employee model attribute*/
		theModel.addAttribute("employee", theEmployee);
		this.LOGGER.info("add employee model attribute");
		
		/** return employee-form html page*/
		this.LOGGER.info("return employee-form html page");
		return "employee-form";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int theId) {
		
		/** delete employee by id from DB*/
		this.employeeService.delete(theId);
		this.LOGGER.info("delete employee by id from DB");
		
		this.LOGGER.info("redirect to /employees/list controller");
		return "redirect:/employees/list";
	}

}
