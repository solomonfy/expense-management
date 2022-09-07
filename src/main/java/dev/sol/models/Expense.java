package dev.sol.models;

import java.sql.Date;

//import javax.xml.bind.annotation.XmlRootElement;

//@XmlRootElement
public class Expense {

	private int id;
	private String title;
	private String description;
	private float amount;
	private Date expense_date;
	private Date submission_date;
	private String receipt_image;
	private String status;
	private Date resolved_on;
	private String manager_comment;
	private String resolved_by;
	private int expenseHolderId;

	public Expense() {
		super();
	}

	public Expense(int id, String title, float amount, int expenseHolderId) {
		super();
		this.id = id;
		this.title = title;
		this.amount = amount;
		this.expenseHolderId = expenseHolderId;
	}
	
	public Expense(int id, String title, float amount, Date expense_date, int expenseHolderId) {
		super();
		this.id = id;
		this.title = title;
		this.amount = amount;
		this.expense_date = expense_date;
		this.expenseHolderId = expenseHolderId;
	}

	public Expense(int id, String title, String description, float amount, Date expense_date, String status,
			int expenseHolderId) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.amount = amount;
		this.expense_date = expense_date;
		this.status = status;
		this.expenseHolderId = expenseHolderId;
	}
	
	public Expense(int id, String title, String description, float amount, Date expense_date,
			int expenseHolderId) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.amount = amount;
		this.expense_date = expense_date;
		this.expenseHolderId = expenseHolderId;
	}

	public Expense(int id, String title, String description, float amount, Date expense_date, Date submission_date,
			String status, int expenseHolderId) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.amount = amount;
		this.expense_date = expense_date;
		this.submission_date = submission_date;
		this.status = status;
		this.expenseHolderId = expenseHolderId;
	}

	public Expense(int id, String title, String description, float amount, Date expense_date, Date submission_date,
			String receipt_image, String status, Date resolved_on, String manager_comment, String resolved_by,
			int expenseHolderId) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.amount = amount;
		this.expense_date = expense_date;
		this.submission_date = submission_date;
		this.receipt_image = receipt_image;
		this.status = status;
		this.resolved_on = resolved_on;
		this.manager_comment = manager_comment;
		this.resolved_by = resolved_by;
		this.expenseHolderId = expenseHolderId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public Date getExpense_date() {
		return expense_date;
	}

	public void setExpense_date(Date expense_date) {
		this.expense_date = expense_date;
	}

	public Date getSubmission_date() {
		return submission_date;
	}

	public void setSubmission_date(Date submission_date) {
		this.submission_date = submission_date;
	}

	public String getReceipt_image() {
		return receipt_image;
	}

	public void setReceipt_image(String receipt_image) {
		this.receipt_image = receipt_image;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getResolved_on() {
		return resolved_on;
	}

	public void setResolved_on(Date resolved_on) {
		this.resolved_on = resolved_on;
	}

	public String getManager_comment() {
		return manager_comment;
	}

	public void setManager_comment(String manager_comment) {
		this.manager_comment = manager_comment;
	}

	public String getResolved_by() {
		return resolved_by;
	}

	public void setResolved_by(String resolved_by) {
		this.resolved_by = resolved_by;
	}

	public int getExpenseHolder() {
		return expenseHolderId;
	}

	public void setExpenseHolder(int expenseHolderId) {
		this.expenseHolderId = expenseHolderId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(amount);
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + expenseHolderId;
		result = prime * result + ((expense_date == null) ? 0 : expense_date.hashCode());
		result = prime * result + id;
		result = prime * result + ((manager_comment == null) ? 0 : manager_comment.hashCode());
		result = prime * result + ((receipt_image == null) ? 0 : receipt_image.hashCode());
		result = prime * result + ((resolved_by == null) ? 0 : resolved_by.hashCode());
		result = prime * result + ((resolved_on == null) ? 0 : resolved_on.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((submission_date == null) ? 0 : submission_date.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Expense other = (Expense) obj;
		if (Float.floatToIntBits(amount) != Float.floatToIntBits(other.amount))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (expenseHolderId != other.expenseHolderId)
			return false;
		if (expense_date == null) {
			if (other.expense_date != null)
				return false;
		} else if (!expense_date.equals(other.expense_date))
			return false;
		if (id != other.id)
			return false;
		if (manager_comment == null) {
			if (other.manager_comment != null)
				return false;
		} else if (!manager_comment.equals(other.manager_comment))
			return false;
		if (receipt_image == null) {
			if (other.receipt_image != null)
				return false;
		} else if (!receipt_image.equals(other.receipt_image))
			return false;
		if (resolved_by == null) {
			if (other.resolved_by != null)
				return false;
		} else if (!resolved_by.equals(other.resolved_by))
			return false;
		if (resolved_on == null) {
			if (other.resolved_on != null)
				return false;
		} else if (!resolved_on.equals(other.resolved_on))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (submission_date == null) {
			if (other.submission_date != null)
				return false;
		} else if (!submission_date.equals(other.submission_date))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Expense [id=" + id + ", title=" + title + ", description=" + description + ", amount=" + amount
				+ ", expense_date=" + expense_date + ", submission_date=" + submission_date + ", receipt_image="
				+ receipt_image + ", status=" + status + ", resolved_on=" + resolved_on + ", manager_comment="
				+ manager_comment + ", resolved_by=" + resolved_by + ", expenseHolderId=" + expenseHolderId + "]";
	}

}
