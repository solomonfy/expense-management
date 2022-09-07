package dev.sol.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import dev.sol.models.Expense;
import dev.sol.util.ConnectionUtil;

public class ExpenseDaoImpl implements ExpenseDao {

	private List<Expense> allExpenses = new ArrayList<>();

	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

	private static Logger log = Logger.getRootLogger();

	@Override
	public List<Expense> getAllExpenses() {
		String sql = "SELECT * FROM EMPLOYEE_EXPENSES_DETAIL";

		log.info("Getting all expenses");

		try (Connection connection = ConnectionUtil.getConnection();
				Statement statement = connection.createStatement();) {

			if (connection != null) {
				ResultSet rs = statement.executeQuery(sql);
				while (rs.next()) {
					Expense expense = new Expense();

					expense.setId(rs.getInt("EXPENSE_ID"));
					expense.setTitle(rs.getString("TITLE"));
					expense.setDescription(rs.getString("DESCRIPTION"));
					expense.setAmount(rs.getFloat("AMOUNT"));
					expense.setExpense_date(rs.getDate("EXPENSE_DATE"));
					expense.setSubmission_date(rs.getDate("SUBMISSION_DATE"));
					expense.setReceipt_image(rs.getString("RECEIPT_IMAGE"));
					expense.setResolved_on(rs.getDate("RESOLVED_ON"));
					expense.setResolved_by(rs.getString("RESOLVED_BY"));
					expense.setManager_comment(rs.getString("MANAGER_COMMENT"));
					expense.setStatus(rs.getString("STATUS"));
					expense.setExpenseHolder(rs.getInt("EMPLOYEE_ID"));

					allExpenses.add(expense);

				}
			}
		} catch (Exception e) {
			log.error("Exception was thrown from - " + e.getClass());
			e.printStackTrace();
		}
		return allExpenses;
	}

	@Override
	public List<Expense> getExpensesByEmployee(int employeeId) {
		List<Expense> employeeExpenses = new ArrayList<>();
		String sql = "SELECT * FROM EMPLOYEE_EXPENSES_DETAIL WHERE EMPLOYEE_ID = ?";

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pStatement = connection.prepareStatement(sql)) {
			pStatement.setInt(1, employeeId);

			if (connection != null) {
				ResultSet rs = pStatement.executeQuery();

				while (rs.next()) {
					Expense expense = new Expense();

					expense.setId(rs.getInt("EXPENSE_ID"));
					expense.setTitle(rs.getString("TITLE"));
					expense.setDescription(rs.getString("DESCRIPTION"));
					expense.setAmount(rs.getFloat("AMOUNT"));
					expense.setExpense_date(rs.getDate("EXPENSE_DATE"));
					expense.setSubmission_date(rs.getDate("SUBMISSION_DATE"));
					expense.setReceipt_image(rs.getString("RECEIPT_IMAGE"));
					expense.setResolved_on(rs.getDate("RESOLVED_ON"));
					expense.setResolved_by(rs.getString("RESOLVED_BY"));
					expense.setManager_comment(rs.getString("MANAGER_COMMENT"));
					expense.setStatus(rs.getString("STATUS"));
					expense.setExpenseHolder(rs.getInt("EMPLOYEE_ID"));

					employeeExpenses.add(expense);

				}
				rs.close();
			}
			return employeeExpenses;

		} catch (Exception e) {
			log.error("Exception was thrown from - " + e.getClass());
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Expense getExpenseById(int id) {

		Expense foundExpense = new Expense();

		String sql = "SELECT * FROM EXPENSE WHERE EXPENSE_ID = ?";

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pStatement = connection.prepareStatement(sql)) {

			pStatement.setInt(1, id);

			if (connection != null) {
				ResultSet rs = pStatement.executeQuery();

				while (rs.next()) {

					foundExpense.setId(rs.getInt("EXPENSE_ID"));
					foundExpense.setTitle(rs.getString("TITLE"));
					foundExpense.setDescription(rs.getString("DESCRIPTION"));
					foundExpense.setAmount(rs.getFloat("AMOUNT"));
					foundExpense.setExpense_date(rs.getDate("EXPENSE_DATE"));
					foundExpense.setSubmission_date(rs.getDate("SUBMISSION_DATE"));
					foundExpense.setReceipt_image(rs.getString("RECEIPT_IMAGE"));
					foundExpense.setResolved_on(rs.getDate("RESOLVED_ON"));
					foundExpense.setResolved_by(rs.getString("RESOLVED_BY"));
					foundExpense.setManager_comment(rs.getString("MANAGER_COMMENT"));
					foundExpense.setStatus(rs.getString("STATUS"));
					foundExpense.setExpenseHolder(rs.getInt("EMPLOYEE_ID"));

					return foundExpense;

				}
				rs.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Expense addNewExpense(Expense newExpense) {
		log.info("New expense has been added");
		int expenseId = 0;

		String expenseSql = "INSERT INTO EXPENSE (EMPLOYEE_ID, TITLE, DESCRIPTION, AMOUNT, EXPENSE_DATE) VALUES (?,?,?,?,?) ";
		String idSQL = "SELECT MAX(EXPENSE_ID) FROM EXPENSE";

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement expensePrepareStatement = connection.prepareStatement(expenseSql);
				Statement statement = connection.createStatement();) {

			expensePrepareStatement.setInt(1, newExpense.getExpenseHolder());
			expensePrepareStatement.setString(2, newExpense.getTitle());
			expensePrepareStatement.setString(3, newExpense.getDescription());
			expensePrepareStatement.setFloat(4, newExpense.getAmount());
			expensePrepareStatement.setDate(5, (newExpense.getExpense_date()));

			expensePrepareStatement.execute();

			ResultSet rs = statement.executeQuery(idSQL);

			if (rs.next()) {
				expenseId = rs.getInt(1);
			}

			if (newExpense != null) {
				newExpense.setId(expenseId);
				System.out.println(newExpense);
				System.out.println("Expense has been added!");
			}

		} catch (Exception e) {
			System.out.println("Trying to add a new record " + e.getMessage());
			log.error("Exception was thrown from - " + e.getClass());
			e.printStackTrace();
		}

		return newExpense;
	}

	@Override
	public Expense editExpense(Expense expense) {

		return null;
	}

	@Override
	public boolean approveEmployeeExpense(int id, String manager_comment, String resolved_by, String status)
			throws SQLException {
		log.info("Expense status updated to " + status);
		String approveExpenseSql = "UPDATE EXPENSE SET STATUS = ?, MANAGER_COMMENT = ?, RESOLVED_BY = ? WHERE EXPENSE_ID = ?";
		int numOfExpenseUpdated = 0;

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement expensePStatement = connection.prepareStatement(approveExpenseSql);) {

			expensePStatement.setString(1, status);
			expensePStatement.setString(2, manager_comment);
			expensePStatement.setString(3, resolved_by);
			expensePStatement.setInt(4, id);

			numOfExpenseUpdated = expensePStatement.executeUpdate();

			if (numOfExpenseUpdated == 1) {
				ExpenseDaoImpl newImpl = new ExpenseDaoImpl();
				System.out.println(newImpl.getExpenseById(id));
				System.out.println(numOfExpenseUpdated);
				return true;
			}

		} catch (SQLException e) {
			System.out.println("Trying to edit a record " + e.getMessage());
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public Expense deleteExpense(Expense expense) {
		// TODO Auto-generated method stub
		return null;
	}

}
