package dev.sol.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import dev.sol.models.Employee;
import dev.sol.util.ConnectionUtil;

public class EmployeeDaoImpl implements EmployeeDao{
	
	
	private static Logger log = Logger.getRootLogger();


	public EmployeeDaoImpl() {

	}


	public List<Employee> getAllEmployee() {
		log.info("Get all employees");

		List<Employee> employees = new ArrayList<>();
		String sql = "SELECT  * FROM EMPLOYEE";

		try (Connection connection = ConnectionUtil.getConnection();
				Statement statement = connection.createStatement();) {

			ResultSet rs = statement.executeQuery(sql);

			while(rs.next()) {
				Employee employee = new Employee();

				employee.setId(rs.getInt("EMPLOYEE_ID"));
				employee.setFirstName(rs.getString("FIRST_NAME"));
				employee.setLastName(rs.getString("LAST_NAME"));
				employee.setEmail(rs.getString("EMAIL"));
				employee.setUserName(rs.getString("USER_NAME"));
				employee.setPassword(rs.getString("PASSWORD"));
				employee.setEmployee_role(rs.getString("EMPLOYEE_ROLE"));

				employees.add(employee);


			}

		} catch (Exception e) {
			e.printStackTrace();
		}


		return employees;
	}


	public Employee addNewEmployee(Employee newEmployee) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Employee editEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employee;
	}



}
