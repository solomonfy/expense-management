package dev.sol.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import dev.sol.models.Expense;
import dev.sol.services.ExpenseService;

public class ExpenseServlet extends HttpServlet {

	
	
	private static final long serialVersionUID = 1L;
	private ExpenseService expenseService = new ExpenseService();

	public void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("Get employee expenses");
		
		String employeeId = request.getParameter("id");
		List<Expense> myExpenses = null;
		
		if(employeeId != null && employeeId.matches("^\\d+$")) {
			myExpenses = expenseService.getEmployeeExpenses(Integer.parseInt(employeeId));			
		} else {
			System.out.println("Nothing to display");
			response.sendError(400);
		}
		
		ObjectMapper om = new ObjectMapper();
		String expensesJson = om.writeValueAsString(myExpenses);
		System.out.println(expensesJson);
		
		
		
		
	}
	
	public void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("Posting new expenses");
		
		String employeeId = request.getParameter("id");
		
		
		BufferedReader br = request.getReader();
		String json = "";
		String line = br.readLine();
		while(line!=null) {
			json = json + line;
			line = br.readLine();
		}
		
		ObjectMapper om = new ObjectMapper();
		Expense expense = om.readValue(json, Expense.class);
		
		System.out.println(expense);
		
		
	}
	
	
}
