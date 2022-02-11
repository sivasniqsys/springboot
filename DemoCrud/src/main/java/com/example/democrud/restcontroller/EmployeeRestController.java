package com.example.democrud.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.democrud.entity.Employee;
import com.example.democrud.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeRestController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return  employeeService.getAllEmployees();
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		Employee theEmployee = employeeService.findById(employeeId);
		if(theEmployee == null) {
			throw new RuntimeException("Employee is null");
		}
		return theEmployee;
		
	}
	@PostMapping("employees")
	public Employee AddEmployee(@RequestBody Employee theEmployee) {
		theEmployee.setId(0);
		employeeService.save(theEmployee);
		return theEmployee;
		
	}
	
	@PutMapping("employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		employeeService.save(theEmployee);
		return theEmployee;
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		Employee employee = employeeService.findById(employeeId);
		if(employee == null) {
			throw new RuntimeException("Employee id is incorrect, Please give a valid Employee id");
		}
		employeeService.deleteById(employeeId);
		return employee.getFirstname()+" is Deleted having id: "+employeeId;
	}
}
