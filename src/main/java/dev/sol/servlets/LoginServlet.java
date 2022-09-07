package dev.sol.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import dev.sol.models.Employee;
import dev.sol.services.EmployeeService;

public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private EmployeeService empService = new EmployeeService();
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {		
		
		System.out.println("Post request to Login Servlet");
		
		ObjectMapper om = new ObjectMapper();

		Employee employeeCredentials = om.readValue(request.getReader(), Employee.class);
		Employee employee = empService.findUserByUsernameandPassword(employeeCredentials.getUserName(), employeeCredentials.getPassword());
		
		System.out.println(employee);
		
		if(employee != null) {
			String token = employee.getId()+ ":" + employee.getUserName() + ":" + employee.getEmployee_role();
			try(PrintWriter pw = response.getWriter()) {
				pw.write(token);
			}
		} else {
			response.sendError(401);
		}
		
	}
	
}
