package imcs.core.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import imcs.core.model.Employee;

public interface EmployeeService {
	
	public List<Employee> loadFromFile() throws FileNotFoundException, IOException, ParseException;
	public List<Employee> getAllEmployeeDetails(int deptNo) throws SQLException;

}
