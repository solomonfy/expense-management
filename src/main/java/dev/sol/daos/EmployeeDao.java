package dev.sol.daos;

import java.util.List;
import dev.sol.models.Employee;


public interface EmployeeDao {
	
	public List<Employee> getAllEmployee();
	public Employee addNewEmployee(Employee newEmployee);
	public Employee editEmployee(Employee employee);

}
