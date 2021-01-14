package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.dao.EmpRepository;
import com.hcl.model.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmpRepository repo;
	
	public boolean saveEmployee(Employee emp) {
		try {
			repo.save(emp);
			return true;
		} catch(Exception e) {
			System.out.println("can't save");
			return false;
		}
	}
	
	public List<Employee> findAllEmployees() {
		return (List<Employee>) repo.findAll();
	}
	
	public Optional<Employee> findEmployeeById(long id) {
		return repo.findById(id);
	}
	
	public boolean deleteEmployee(Employee emp) {
		try {
			repo.delete(emp);
			return true;
		} catch( Exception e) {
			System.out.println("Couldn't delete");
			return false;
		}
	}
}
