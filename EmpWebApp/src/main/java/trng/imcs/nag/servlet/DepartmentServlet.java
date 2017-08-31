package trng.imcs.nag.servlet;

import java.io.IOException;
import java.sql.SQLException;
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
import trng.imcs.core.dao.EmployeeDAO;
import trng.imcs.core.dao.impl.EmployeeDAOImpl;

public class DepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final Logger logger = Logger.getLogger(DepartmentServlet.class);

	public DepartmentServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rDispatcher;
		int deptId = Integer.parseInt(request.getParameter("deptId"));
		Integer dept = Integer.valueOf(deptId);
		EmployeeDAO dao = new EmployeeDAOImpl();
		List<Employee> empList = null;
		try {
			empList = dao.getAll(deptId);
		} catch (SQLException e) {
			logger.info(e.getMessage());
		}
		String url = "";
		if (empList.size() != 0) {
			request.setAttribute("empList", empList);
			request.setAttribute("dept", dept);
			url = "/home.jsp";
		} else {
			request.setAttribute("msg", "user doesn't exists with the given ID " + deptId);
		}
		rDispatcher = request.getRequestDispatcher(url);
		rDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
