package imcs.core.model;

import java.sql.Date;

public class EmployeeBonus {

	private int empId;
	private String status;
	private float amount;
	private Date dateAllocated;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public EmployeeBonus() {

	}

	public EmployeeBonus(int empId, String status, float amount, Date dateAllocated) {
		super();
		this.empId = empId;
		this.status = status;
		this.amount = amount;
		this.dateAllocated = dateAllocated;
	}

	@Override
	public String toString() {
		return "EmployeeBonus [empId=" + empId + ", status=" + status + ", amount=" + amount + ", dateAllocated="
				+ dateAllocated + "]";
	}

	public String isStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public Date getDateAllocated() {
		return dateAllocated;
	}

	public void setDateAllocated(Date date) {
		this.dateAllocated = date;
	}

}
