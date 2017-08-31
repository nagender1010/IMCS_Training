package trng.imcs.nag.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import imcs.core.model.Employee;
import imcs.core.service.EmployeeService;
import imcs.core.serviceImpl.EmployeeServiceImpl;
import trng.imcs.core.dao.EmployeeDAO;
import trng.imcs.core.dao.impl.EmployeeDAOImpl;

public class UpdateEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final Logger logger = Logger.getLogger(EmployeeServlet.class);

	public UpdateEmployeeServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rDispatcher;
		Employee emp = null;
		int empId = 0;
		empId = Integer.parseInt(request.getParameter("uempId"));
		EmployeeService es = new EmployeeServiceImpl();
		Employee eInfo = null;
		try {
			eInfo = es.getEmployee(empId);
		} catch (SQLException ex) {
			logger.info(ex.getMessage());
		}
		String url = "";
		String name = eInfo.getName();
		int age = eInfo.getAge();
		Date dateOfBirth = eInfo.getDateOfBirth();
		Date dateOfJoining = eInfo.getDateOfJoining();
		float salary = eInfo.getSalary();
		int salaryGrade = eInfo.getSalaryGrade();
		int deptId = eInfo.getDeptId();
		String deptName = eInfo.getDeptName();

		if (eInfo.getId() != 0) {
			request.setAttribute("uid", empId);
			request.setAttribute("uname", name);
			request.setAttribute("uage", age);
			request.setAttribute("udob", dateOfBirth);
			request.setAttribute("udoj", dateOfJoining);
			request.setAttribute("usalary", salary);
			request.setAttribute("usalarygrade", salaryGrade);
			request.setAttribute("udeptid", deptId);
			request.setAttribute("udeptname", deptName);
			emp = new Employee(empId, name, age, dateOfJoining, dateOfBirth, salary, salaryGrade, deptId, deptName);
			request.setAttribute("emp", emp);
			url = "/home.jsp";
		} else {
			request.setAttribute("msg", "User ID " + empId + " doesn't exists");
		}
		rDispatcher = request.getRequestDispatcher(url);
		rDispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("operations").equals("updateOper")) {
			System.out.println("checking");
			doGet(request, response);
			return;
		}
		RequestDispatcher rDispatcher;
		Employee e = null;
		int id = Integer.parseInt(request.getParameter("uid"));
		String name = request.getParameter("uname");
		int age = Integer.parseInt(request.getParameter("uage"));
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		Date dob = null;
		Date doj = null;
		try {
			dob = sd.parse(request.getParameter("udob"));
			doj = sd.parse(request.getParameter("udoj"));

		} catch (ParseException e2) {
			logger.info(e2.getMessage());
		}
		float salary = Float.parseFloat(request.getParameter("usalary"));
		int salaryGrade = Integer.parseInt(request.getParameter("usalarygrade"));
		int deptId = Integer.parseInt(request.getParameter("udeptid"));
		String deptName = request.getParameter("udeptname");
		e = new Employee(id, name, age, doj, dob, salary, salaryGrade, deptId, deptName);
		System.out.println("printing employee in servlet " + e);
		EmployeeService es = new EmployeeServiceImpl();
		try {
			es.updateEmployee(e);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		request.setAttribute("msg", "User ID " + id + " updated successfully");
		String url = "/home.jsp";

		rDispatcher = request.getRequestDispatcher(url);
		rDispatcher.forward(request, response);

	}
}
