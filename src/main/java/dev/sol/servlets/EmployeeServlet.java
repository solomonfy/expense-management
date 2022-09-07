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

public class EmployeeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private EmployeeService employeeService = new EmployeeService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("Get request to Employees Servlet");

//		List<Employee> employees = employeeService.getEmployees();
//		
////		System.out.println(employees);
//		
//		ObjectMapper om = new ObjectMapper(); // to convert java obj. to JSON obj.
//		
//			String employeesJson = om.writeValueAsString(employees);
////			System.out.println(employeesJson);
//			PrintWriter pw = response.getWriter();
//			pw.write(employeesJson);
//			pw.close();

		Employee foundEmployee = null;

		String employeeId = request.getParameter("id");

		if (employeeId != null && employeeId.matches("^\\d+$")) {

			foundEmployee = employeeService.findEmployeeById(Integer.parseInt(employeeId));
		} else {
			response.sendError(400);
		}

		ObjectMapper om = new ObjectMapper();

		String employeesJson = om.writeValueAsString(foundEmployee);
		System.out.println(employeesJson);
		PrintWriter pw = response.getWriter();
		pw.write(employeesJson);
		pw.close();

	}

}
