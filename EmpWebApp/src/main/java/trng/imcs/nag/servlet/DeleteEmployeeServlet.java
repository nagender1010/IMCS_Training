package trng.imcs.nag.servlet;

import java.io.IOException;
import java.sql.SQLException;
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
import trng.imcs.nag.filter.LogFilter;

public class DeleteEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final Logger logger = Logger.getLogger(DeleteEmployeeServlet.class);

	public DeleteEmployeeServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rDispatcher;
		int id = Integer.parseInt(request.getParameter("deleteEmpId"));
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
}
