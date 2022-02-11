package com.example.democrud.dao;

import java.util.List;

import com.example.democrud.entity.Employee;

public interface EmployeeDAO {
	public List<Employee> getEmployeeList();
	public Employee findById(int id);
	public void save(Employee employee);
	public void deleteById(int employeeId);
}
