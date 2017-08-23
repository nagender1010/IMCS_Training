package imcs.core.model;

import java.util.Date;

public class Employee {

	private int id;
	private String name;
	private int age;
	private Date dateOfJoining;
	private Date dateOfBirth;
	private float salary;
	private int salaryGrade;
	private int deptId;
	private String deptName;

	public Employee(int id, String name, int age, Date dateOfJoining, Date dateOfBirth, float salary, int salaryGrade,
			int deptId, String deptName) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.dateOfJoining = dateOfJoining;
		this.dateOfBirth = dateOfBirth;
		this.salary = salary;
		this.salaryGrade = salaryGrade;
		this.deptId = deptId;
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", dateOfJoining=" + dateOfJoining
				+ ", dateOfBirth=" + dateOfBirth + ", salary=" + salary + ", salaryGrade=" + salaryGrade + ", deptId="
				+ deptId + ", deptName=" + deptName + "]";
	}

	public Employee() {
		super();
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public int getSalaryGrade() {
		return salaryGrade;
	}

	public void setSalaryGrade(int salaryGrade) {
		this.salaryGrade = salaryGrade;
	}

}
