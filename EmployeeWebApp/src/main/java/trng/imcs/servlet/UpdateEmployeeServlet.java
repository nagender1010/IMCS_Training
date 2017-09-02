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

@WebServlet("/updateEmployee")
public class UpdateEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final Logger logger = Logger.getLogger(EmployeeServlet.class);

	public UpdateEmployeeServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rDispatcher;
		int id = Integer.parseInt(request.getParameter("deleteId"));
		EmployeeService es = new EmployeeServiceImpl();
		boolean status = false;
		String url = null;
		try {
			status = es.deleteEmployee(id);
		} catch (SQLException e1) {
			logger.info(e1.getMessage());
		}
		if (status == true) {
			request.setAttribute("msg", "User with ID " + id + " deleted successfully");
		} else {
			request.setAttribute("msg", "User doesn't exist with the given ID");
		}
		url = "/home.jsp";
		rDispatcher = request.getRequestDispatcher(url);
		rDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rDispatcher;
		Employee e = null;
		boolean status = false;
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
			status = es.updateEmployee(e);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		if(status == true) {
			request.setAttribute("msg", "User ID " + id + " updated successfully");
			request.setAttribute("status", false);
			String url = "/home.jsp";
			request.setAttribute("eInfo", e);
			rDispatcher = request.getRequestDispatcher(url);
			rDispatcher.forward(request, response);
			
		}

		request.setAttribute("msg", "User ID " + id + " doesn't exists");
		String url = "/home.jsp";
		rDispatcher = request.getRequestDispatcher(url);
		rDispatcher.forward(request, response);
		

	}
}
