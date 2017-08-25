package imcs.core.model;

public class Bonus {

	private int deptNo;
	private float amount;
	private float remainingAmount;

	public Bonus() {
		super();
	}

	public Bonus(int deptNo, float amount, float remainingAmount) {
		super();
		this.deptNo = deptNo;
		this.amount = amount;
		this.remainingAmount = remainingAmount;
	}

	public int getDeptNo() {
		return deptNo;
	}

	@Override
	public String toString() {
		return "Bonus [deptNo=" + deptNo + ", amount=" + amount + ", remainingAmount=" + remainingAmount + "]";
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public float getRemainingAmount() {
		return remainingAmount;
	}

	public void setRemainingAmount(float remainingAmount) {
		this.remainingAmount = remainingAmount;
	}

}
