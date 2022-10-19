package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Employee;

public interface EmployeeService {

	public List<Employee> findAll();
	public Employee findById(int theEmployeeId);
	public void save(Employee theEmployee);
	public void deleteById(int theId);

}