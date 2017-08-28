package trng.imcs.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import imcs.core.model.Employee;
import trng.imcs.core.dao.EmployeeDAO;
import trng.imcs.core.dao.impl.EmployeeDAOImpl;

public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EmployeeServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rDispatcher;
		int deptId = 0;
		try {
			deptId = Integer.parseInt(request.getParameter("deptId"));
		} catch (Exception e) {
			rDispatcher = request.getRequestDispatcher("error.jsp");
			rDispatcher.forward(request, response);
		}
		
		Integer dept = Integer.valueOf(deptId);
		HttpSession session = request.getSession();
		EmployeeDAO dao = new EmployeeDAOImpl();
		List<Employee> empList = null;
		try {
			empList = dao.getAll(deptId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String url = "";
		// String flag = result.substring(0,1);
		if (empList.size() != 0) {
			session.setAttribute("empList", empList);
			session.setAttribute("dept", dept);
			url = "/empList.jsp";
		} else {
			url = "/error.jsp";
		}
		rDispatcher = request.getRequestDispatcher(url);
		rDispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rDispatcher;
		int empId=0;
		try {
			empId = Integer.parseInt(request.getParameter("empId"));
		}catch (Exception e) {
			rDispatcher = request.getRequestDispatcher("/crerror.jsp");
			rDispatcher.forward(request, response);
		}
		
		HttpSession session = request.getSession();
		EmployeeDAO dao = new EmployeeDAOImpl();
		Employee eInfo = null;
		try {
			eInfo = dao.getEmployee(empId);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		String url = "";
	
		System.out.println("printing eInfo" + eInfo);
		if (eInfo.getId() != 0) {
			session.setAttribute("eInfo", eInfo);
			url = "/departList.jsp";
		} else {
			url = "/crerror.jsp";
		}
		rDispatcher = request.getRequestDispatcher(url);
		rDispatcher.forward(request, response);

	}
}
