package dev.sol.services;

import java.util.List;

import dev.sol.daos.EmployeeDaoImpl;
import dev.sol.models.Employee;

public class EmployeeService {
	
	private EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();

	List<Employee> allEmployees = employeeDao.getAllEmployee();
	
	
	
	
	public List<Employee> getEmployees() {
		
		return allEmployees;
	}

	
	public Employee findUserByUsernameandPassword(String username, String password) {
		
		for(Employee employee : allEmployees) {
			
			if(employee != null) {
				if(employee.getUserName() != null && employee.getUserName().equals(username)) {
					if(employee.getPassword() != null & employee.getPassword().equals(password)) {
						return employee;
					}
				}
			}
		}
		return null;
	}
	
	public Employee findEmployeeById(int id) {
		for (Employee foundEmployee : allEmployees) {
			if(foundEmployee != null && foundEmployee.getId() == id) {
				return foundEmployee;
			}
		}
		return null;
		
	}
	
	
}
