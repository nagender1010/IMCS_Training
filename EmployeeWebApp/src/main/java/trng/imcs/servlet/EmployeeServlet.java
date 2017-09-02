package trng.imcs.servlet;

import java.io.IOException;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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

@WebServlet("/employee")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final Logger logger = Logger.getLogger(EmployeeServlet.class);
	EmployeeService es = new EmployeeServiceImpl();

	public EmployeeServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rDispatcher;
		int empId = Integer.parseInt(request.getParameter("eSearch"));
		String operations = request.getParameter("operations");
		if (operations != null && operations.equals("updateOperFrmDept")) {
			int deptId = Integer.parseInt(request.getParameter("DeptId"));
			request.setAttribute("pageType", "updateOperFrmDept");
		} else {
			request.setAttribute("pageType", "fromEmployee");
		}

		Employee eInfo = null;
		try {
			eInfo = es.getEmployee(empId);
		} catch (SQLException ex) {
			logger.info(ex.getMessage());
		}
		String url = "";

		System.out.println("printing eInfo" + eInfo);
		if (eInfo.getId() != 0) {
			request.setAttribute("eInfo", eInfo);
			request.setAttribute("status", true);
			url = "/home.jsp";
		} else {
			request.setAttribute("msg", "User doesnt exists with the given ID " + empId);
		}

		rDispatcher = request.getRequestDispatcher(url);
		rDispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rDispatcher;
		Employee e = null;

		String name = request.getParameter("ename");
		int age = Integer.parseInt(request.getParameter("age"));
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		Date dob = null;
		Date doj = null;
		int id = 0;
		try {
			dob = sd.parse(request.getParameter("dob"));
			doj = sd.parse(request.getParameter("doj"));
		} catch (ParseException e2) {
			e2.printStackTrace();
		}
		float salary = Float.parseFloat(request.getParameter("salary"));
		int salaryGrade = Integer.parseInt(request.getParameter("salarygrade"));
		int deptId = Integer.parseInt(request.getParameter("deptid"));
		String deptName = request.getParameter("deptname");
		e = new Employee(name, age, doj, dob, salary, salaryGrade, deptId, deptName);
		try {
			id = es.addEmployee(e);
		} catch (SQLException e1) {
			logger.info(e1.getMessage());
		}
		if (id != 0) {
			e.setId(id);
			request.setAttribute("msg", "User added successfully");
			request.setAttribute("status", false);
			request.setAttribute("eInfo", e);
			String url = "/home.jsp";
			rDispatcher = request.getRequestDispatcher(url);
			rDispatcher.forward(request, response);

		}

	}
}
