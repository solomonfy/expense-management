package dev.sol.models;

import java.time.LocalDate;
import java.util.List;


public class Employee {
	
static LocalDate today = LocalDate.now();
	
	private int id;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String email;
	private String employee_role ;
	private List<Expense> expenses;
	
	

	public Employee() {
		super();
	}



	public Employee(int id, String firstName, String lastName, String userName, String password, String email,
			String employee_role, List<Expense> expenses) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.employee_role = employee_role;
		this.expenses = expenses;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getEmployee_role() {
		return employee_role;
	}



	public void setEmployee_role(String employee_role) {
		this.employee_role = employee_role;
	}



	public List<Expense> getExpenses() {
		return expenses;
	}



	public void setExpenses(List<Expense> expenses) {
		this.expenses = expenses;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((employee_role == null) ? 0 : employee_role.hashCode());
		result = prime * result + ((expenses == null) ? 0 : expenses.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + id;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (employee_role == null) {
			if (other.employee_role != null)
				return false;
		} else if (!employee_role.equals(other.employee_role))
			return false;
		if (expenses == null) {
			if (other.expenses != null)
				return false;
		} else if (!expenses.equals(other.expenses))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id != other.id)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName
				+ ", password=" + password + ", email=" + email + ", employee_role=" + employee_role + ", expenses="
				+ expenses + "]";
	}
	

}
