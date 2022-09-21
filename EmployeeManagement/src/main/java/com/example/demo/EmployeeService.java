package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;

	public List<Employee> getAllEmployee() {
		List<Employee> emp = new ArrayList<Employee>();
		employeeRepository.findAll().forEach(emp1 -> emp.add(emp1));
		return emp;
	}


	public Employee getEmployeeById(int id) {
		return employeeRepository.findById(id).get();
	}

  
	public void saveOrUpdate(Employee employee) {
		employeeRepository.save(employee);
	}

  
	public void delete(int id) {
		employeeRepository.deleteById(id);
	}


	public void update(Employee employee, int id) {
		employeeRepository.save(employee);
	}
}