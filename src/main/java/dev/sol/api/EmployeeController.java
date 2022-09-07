package dev.sol.api;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dev.sol.models.Employee;
import dev.sol.models.Expense;
import dev.sol.services.EmployeeService;
import dev.sol.services.ExpenseService;

@Path("/employees")
public class EmployeeController {
	
	private EmployeeService empService = new EmployeeService();
	private ExpenseService expService = new ExpenseService();
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	
	public List<Employee> getAllEmployees() {
		return empService.getEmployees();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEmployeeById(@PathParam("id") int id) {
		Employee foundEmployee = empService.findEmployeeById(id);
		
		if(foundEmployee == null) {
			return Response.status(404).build();
		} else {
			return Response.status(200).entity(foundEmployee).build();
		}
	}
	
	
	@GET
	@Path("/{id}/expenses")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Expense> getEmployeeExpenses(@PathParam("id") int id) {
		System.out.println(expService.getEmployeeExpenses(id));
		return expService.getEmployeeExpenses(id);
		
	}
}
