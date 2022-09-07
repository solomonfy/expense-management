package dev.sol.daos;

import java.sql.SQLException;
import java.util.List;

import dev.sol.models.*;

public interface ExpenseDao {
	
	
	
	public List<Expense> getAllExpenses();
	public List<Expense> getExpensesByEmployee(int employeeId);
	
	public Expense addNewExpense(Expense newExpense);
	
	public Expense getExpenseById(int id);
	
	
	public boolean approveEmployeeExpense(int id, String manager_comment, String resolved_by, String status) throws SQLException;
	
//	public boolean approveEmployeeExpense(Expense expense) throws SQLException;
	
	public Expense editExpense(Expense expense);
	public Expense deleteExpense(Expense expense);

}
