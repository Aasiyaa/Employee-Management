package com.example.demo;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@GetMapping("/employee")
	private List<Employee> getAllEmployee() {
		return employeeService.getAllEmployee();
	}

//	@GetMapping("/employee/sort/{field}")	
//	private List<Employee> sortEmployees(@PathVariable String field){
//		List<Employee> employeeList = employeeService.getAllEmployee();
//		if(field.equalsIgnoreCase("id")){
//			return employeeList.stream().sorted(Comparator.comparing(Employee::getId)).collect(Collectors.toList());
//		}else if(field.equalsIgnoreCase("id")){
//			return employeeList.stream().sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList());
//		}
//	}
	
	@GetMapping("/employee/{id}")
	private Employee getEmployee(@PathVariable("id") int id) {
		return employeeService.getEmployeeById(id);
		
	}

  
	@DeleteMapping("/employee/{id}")
	private void deleteEmployee(@PathVariable("id") int id) {
		employeeService.delete(id);
		 logger.info("database deleted successfully");
		
	}

 
	@PostMapping("/employee")
	private int saveEmployee(@RequestBody Employee employee) {
		employeeService.saveOrUpdate(employee);
		return employee.getId();
	}


	@PutMapping("/employee")
	private Employee update(@RequestBody Employee employee) {
		employeeService.saveOrUpdate(employee);
		return employee;
	}
}