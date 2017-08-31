package trng.imcs.core.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.Statement;

import connection.ConnectionManager;
import imcs.core.model.Bonus;
import imcs.core.model.Employee;
import imcs.core.model.EmployeeBonus;
import trng.imcs.core.dao.EmployeeDAO;
import trng.imcs.core.exceptions.DuplicateEmployeeException;

public class EmployeeDAOImpl implements EmployeeDAO {

	public void add(List<Employee> empList) {

		final String sql = "insert into employee (id, name, age, dateOfBirth, dateOfJoining, salary, salaryGrade, deptId, deptName) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try (Connection con = ConnectionManager.getConnection();
				Statement st = con.createStatement();
				PreparedStatement preparedStatement = con.prepareStatement(sql)) {

			con.setAutoCommit(false);

			st.execute("truncate employee");
			int count = 1;
			boolean hasLeftOverBatchRecords = true;
			for (Employee e : empList) {

				if (e == null)
					break;

				preparedStatement.setInt(1, e.getId());
				preparedStatement.setString(2, e.getName());
				preparedStatement.setInt(3, e.getAge());
				java.util.Date d = e.getDateOfBirth();
				java.sql.Date dob = new java.sql.Date(d.getYear(), d.getMonth(), d.getDate());
				preparedStatement.setDate(4, dob);
				java.util.Date d1 = e.getDateOfJoining();
				java.sql.Date doj = new java.sql.Date(d1.getYear(), d1.getMonth(), d1.getDate());
				preparedStatement.setDate(5, doj);
				preparedStatement.setFloat(6, e.getSalary());
				preparedStatement.setInt(7, e.getSalaryGrade());
				preparedStatement.setInt(8, e.getDeptId());
				preparedStatement.setString(9, e.getDeptName());

				// Add it to the batch
				preparedStatement.addBatch();

				if (count++ % 4 == 0) {
					// Create an int[] to hold returned values
					int[] updateCount = preparedStatement.executeBatch();
					hasLeftOverBatchRecords = false;
				} else {
					hasLeftOverBatchRecords = true;
				}
			}

			if (hasLeftOverBatchRecords) {
				int[] updateCount = preparedStatement.executeBatch();
			}

			con.commit();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
	
	public void addEmployee(Employee e) {

		final String sql = "insert into employee (id, name, age, dateOfBirth, dateOfJoining, salary, salaryGrade, deptId, deptName) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement preparedStatement = con.prepareStatement(sql)) {
			
			int id = generateId();
			boolean hasLeftOverBatchRecords = true;

				preparedStatement.setInt(1, id);
				preparedStatement.setString(2, e.getName());
				preparedStatement.setInt(3, e.getAge());
				java.util.Date d = e.getDateOfBirth();
				java.sql.Date dob = new java.sql.Date(d.getYear(), d.getMonth(), d.getDate());
				preparedStatement.setDate(4, dob);
				java.util.Date d1 = e.getDateOfJoining();
				java.sql.Date doj = new java.sql.Date(d1.getYear(), d1.getMonth(), d1.getDate());
				preparedStatement.setDate(5, doj);
				preparedStatement.setFloat(6, e.getSalary());
				preparedStatement.setInt(7, e.getSalaryGrade());
				preparedStatement.setInt(8, e.getDeptId());
				preparedStatement.setString(9, e.getDeptName());
				int status = preparedStatement.executeUpdate();
				if (status != 1) {
					con.rollback();
				}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}

	private int generateId() {
		final String sql = "SELECT MAX(id) FROM employee";
		ResultSet rs = null;
		int id=0;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement st = con.prepareStatement(sql)) {
			rs = st.executeQuery(sql);
			while (rs.next()) {
					id = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id+1;
	}

	@Override
	public List<Employee> getAll(int deptId, String orderBy) {
		List<Employee> empList = new ArrayList<>();

		ResultSet rs = null;
		String sql = "select id, name, age, dateOfBirth, dateOfJoining, salary, salaryGrade, deptId, deptName from employee where deptId=? order by "
				+ orderBy;
		try (Connection con = ConnectionManager.getConnection(); PreparedStatement st = con.prepareStatement(sql)) {

			st.setInt(1, deptId);
			rs = st.executeQuery();
			while (rs.next()) {
				Employee e = new Employee();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setAge(rs.getInt(3));
				e.setDateOfBirth(rs.getDate(4));
				e.setDateOfJoining(rs.getDate(5));
				e.setSalary(rs.getFloat(6));
				e.setSalaryGrade(rs.getInt(7));
				e.setDeptId(rs.getInt(8));
				e.setDeptName(rs.getString(9));
				empList.add(e);

			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return empList;
	}//
	
	@Override
	public List<Employee> getAll(int deptId) {
		List<Employee> empList = new ArrayList<>();

		ResultSet rs = null;
		String sql = "select id, name, age, dateOfBirth, dateOfJoining, salary, salaryGrade, deptId, deptName from employee where deptId=?";
		try (Connection con = ConnectionManager.getConnection(); PreparedStatement st = con.prepareStatement(sql)) {

			st.setInt(1, deptId);
			rs = st.executeQuery();
			while (rs.next()) {
				Employee e = new Employee();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setAge(rs.getInt(3));
				e.setDateOfBirth(rs.getDate(4));
				e.setDateOfJoining(rs.getDate(5));
				e.setSalary(rs.getFloat(6));
				e.setSalaryGrade(rs.getInt(7));
				e.setDeptId(rs.getInt(8));
				e.setDeptName(rs.getString(9));
				empList.add(e);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return empList;
	}//
	@Override
	public Employee getEmployee(int empId) {
		Employee e = new Employee();
		ResultSet rs = null;
		String sql = "select id, name, age, dateOfBirth, dateOfJoining, salary, salaryGrade, deptId, deptName from employee where id=?";
		try (Connection con = ConnectionManager.getConnection(); PreparedStatement st = con.prepareStatement(sql)) {

			st.setInt(1, empId);
			rs = st.executeQuery();
			while (rs.next()) {
				
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setAge(rs.getInt(3));
				e.setDateOfBirth(rs.getDate(4));
				e.setDateOfJoining(rs.getDate(5));
				e.setSalary(rs.getFloat(6));
				e.setSalaryGrade(rs.getInt(7));
				e.setDeptId(rs.getInt(8));
				e.setDeptName(rs.getString(9));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return e;
	}//


	@Override
	public List<Employee> getAll() {
		List<Employee> empList = new ArrayList<Employee>();
		ResultSet rs = null;
		String sql = "select id, name, age, dateOfBirth, dateOfJoining, salary, salaryGrade, deptId, deptName from employee";
		try (Connection con = ConnectionManager.getConnection(); PreparedStatement st = con.prepareStatement(sql)) {
			rs = st.executeQuery();
			while (rs.next()) {
				Employee e = new Employee();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setAge(rs.getInt(3));
				e.setDateOfBirth(rs.getDate(4));
				e.setDateOfJoining(rs.getDate(5));
				e.setSalary(rs.getFloat(6));
				e.setSalaryGrade(rs.getInt(7));
				e.setDeptId(rs.getInt(8));
				e.setDeptName(rs.getString(9));
				empList.add(e);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return empList;
	}

	@Override
	public List<Bonus> getAllEmployeeBonus() throws SQLException {
		List<Bonus> bonusList = new ArrayList<Bonus>();
		ResultSet rs = null;
		String sql = "select * from bonus";
		try (Connection con = ConnectionManager.getConnection(); PreparedStatement st = con.prepareStatement(sql)) {
			rs = st.executeQuery();
			while (rs.next()) {
				Bonus e = new Bonus();
				e.setDeptNo(rs.getInt(1));
				e.setAmount(rs.getFloat(2));
				e.setRemainingAmount(rs.getFloat(3));
				bonusList.add(e);
			}
		} finally {
			if (rs != null && !rs.isClosed()) {
				rs.close();
			}
		}
		return bonusList;
	}

	public boolean addEmployeeBonus(final EmployeeBonus e) {
		List<Employee> empList = getAll();

		final String sql = "insert into employeebonus (empId, status, amount, dateAllocated) values (?, ?, ?, ?)";
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement preparedStatement = con.prepareStatement(sql)) {
			preparedStatement.setInt(1, e.getEmpId());
			preparedStatement.setString(2, e.getStatus());
			preparedStatement.setFloat(3, e.getAmount());

			preparedStatement.setDate(4, e.getDateAllocated());
			final int status = preparedStatement.executeUpdate();
			if (status != 1) {
				con.rollback();
				return false;
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return true;

	}

	public Bonus getBonusInfo(int deptId) {
		ResultSet rs = null;
		Bonus b = new Bonus();
		float remainingAmountInDept = 0;
		String sql = "select amount, remainingAmount from bonus where deptNo=?";
		try (Connection con = ConnectionManager.getConnection(); PreparedStatement st = con.prepareStatement(sql)) {

			st.setInt(1, deptId);
			rs = st.executeQuery();
			if (rs.next()) {

				b.setAmount(rs.getFloat(1));
				b.setRemainingAmount(rs.getFloat(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}

	public boolean updateBonusInfo(int deptId, Bonus b) {
		final String sql = "update bonus set remainingAmount=? where deptNo =?";
		try (Connection con = ConnectionManager.getConnection(); PreparedStatement st = con.prepareStatement(sql)) {
			st.setInt(2, deptId);
			st.setFloat(1, b.getRemainingAmount());

			final int status = st.executeUpdate();
			con.close();
			if (status != 1) {
				con.rollback();
				return false;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}
	
	public boolean updateEmployee(Employee e) {
		final String sql = "update employee set name=?, age=?, dateOfBirth=?, dateOfJoining=?, salary=?, salaryGrade=?, deptId=?, deptName=? where id =?";
		try (Connection con = ConnectionManager.getConnection(); PreparedStatement st = con.prepareStatement(sql)) {
			st.setString(1, e.getName());
			st.setInt(2, e.getAge());
			java.util.Date d = e.getDateOfBirth();
			java.sql.Date dob = new java.sql.Date(d.getYear(), d.getMonth(), d.getDate());
			st.setDate(3, dob);
			java.util.Date d1 = e.getDateOfJoining();
			java.sql.Date doj = new java.sql.Date(d1.getYear(), d1.getMonth(), d1.getDate());
			st.setDate(4, doj);
			st.setFloat(5, e.getSalary());
			st.setInt(6, e.getSalaryGrade());
			st.setInt(7, e.getDeptId());
			st.setString(8, e.getDeptName());
			st.setInt(9, e.getId());

			final int status = st.executeUpdate();
			con.close();
			if (status != 1) {
				con.rollback();
				return false;
			}

		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}

		return true;
	}
	
	public boolean deleteEmployee(int empId) {
		final String sql = "delete from employee where id = ?";
		try (Connection con = ConnectionManager.getConnection(); PreparedStatement st = con.prepareStatement(sql)) {
			
			st.setInt(1, empId);

			final int status = st.executeUpdate();
			if (status>0) {
				return true;
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return false;
	}
}
