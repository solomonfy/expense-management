package dev.sol.api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import dev.sol.models.Expense;
import dev.sol.services.ExpenseService;

@Path("/expenses")
public class ExpenseController {
	
	static final Logger LOGGER = Logger.getLogger(ExpenseController.class);

	private ExpenseService expenseService = new ExpenseService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)

	public List<Expense> getAllExpenses() {
		LOGGER.info("This is a logging statement from log4j while getting all expenses");
		return expenseService.getAllExpenses();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findExpenseById(@PathParam("id") int id) {

		return null;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addNewExpense(Expense expense) {
		LOGGER.info("This is a logging statement from log4j when new record is created");
		Expense newExpense = expenseService.addNewExpense(expense);
		if (newExpense != null) {
			return Response.status(201).entity(newExpense).build();
		}
		System.out.println(Response.class);
		return Response.status(400).build();
	}


	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response approveExpense(@PathParam("id") int id, Expense expenseInput) throws Exception {

		System.out.println(expenseInput);

		System.out.println(expenseService.findExpenseById(id));

		boolean updatedSuccess = expenseService.approveExpense(id, expenseInput.getManager_comment(),
				expenseInput.getResolved_by(), expenseInput.getStatus());

		if (updatedSuccess == true) {

			return Response.status(200).entity(expenseInput).header("Access-Control-Allow-Origin", "*")
					.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").build();
		}
		return Response.status(400).build();
	}

	

}
