package dev.sol.services;

import java.util.List;

import dev.sol.daos.ExpenseDaoImpl;
import dev.sol.models.Expense;

public class ExpenseService {

	private ExpenseDaoImpl expDaoImpl = new ExpenseDaoImpl();
	private List<Expense> allExpenses = expDaoImpl.getAllExpenses();
	

//	public static void main(String[] args) {
//		ExpenseDaoImpl expDaoI = new ExpenseDaoImpl();
//	}
	
	
	public List<Expense> getAllExpenses() {
		return allExpenses;
		
	}
	
	public List<Expense> getEmployeeExpenses(int employeeId) {
		return expDaoImpl.getExpensesByEmployee(employeeId);
		
	}
	
	
	public Expense addNewExpense(Expense expense) {
		
		return expDaoImpl.addNewExpense(expense);
		
	}
	
	
	
	public boolean approveExpense(int id, String manager_comment, String resolved_by, String status) throws Exception {
		return expDaoImpl.approveEmployeeExpense(id, manager_comment, resolved_by, status);
	}
	
	
//	public boolean approveExpense(Expense expense) throws Exception {
//		return expDaoImpl.approveEmployeeExpense(expense);
//	}
	
	
	
	public Expense findExpenseById(int expenseId) {
		for(Expense expense : allExpenses) {
			if(expense != null) {
				if(expense.getId() == expenseId) {
					return expense;
				}
			}
		}
		return null;
		
	}
	
}
