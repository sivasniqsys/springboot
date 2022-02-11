package com.example.democrud.service;

import java.util.List;

import com.example.democrud.entity.Employee;

public interface EmployeeService {
	public List<Employee> getAllEmployees();
	public Employee findById(int id);
	public void save(Employee employee);
	public void deleteById(int employeeId);
}
