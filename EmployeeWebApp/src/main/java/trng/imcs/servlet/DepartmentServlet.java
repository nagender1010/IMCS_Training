package trng.imcs.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import imcs.core.model.Department;
import imcs.core.model.Employee;
import imcs.core.service.EmployeeService;
import imcs.core.serviceImpl.EmployeeServiceImpl;
import trng.imcs.core.dao.EmployeeDAO;
import trng.imcs.core.dao.impl.EmployeeDAOImpl;

@WebServlet("/department")
public class DepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmployeeService es = new EmployeeServiceImpl();
	EmployeeDAO dao = new EmployeeDAOImpl();
	
	final Logger logger = Logger.getLogger(DepartmentServlet.class);

	public DepartmentServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rDispatcher;
		Department dept = null;
		String url = null;
		int deptId = Integer.parseInt(request.getParameter("dSearch"));
		System.out.println("entered login");
		
		dept = es.getDepartment(deptId);
		if(dept!=null) {
			url = "/department.jsp";
			request.setAttribute("deptInfo", dept);
			rDispatcher = request.getRequestDispatcher(url);
			rDispatcher.forward(request, response);
		}
		
		url = "/department.jsp";
		request.setAttribute("msg", "Dept info doesn't exist with the given ID");
		rDispatcher = request.getRequestDispatcher(url);
		rDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher rDispatcher;
		int deptId = Integer.parseInt(request.getParameter("departId"));
		Department dept = null;
		dept = es.getDepartment(deptId);
		List<Employee> empList = null;
		try {
			empList = dao.getAll(deptId);
		} catch (SQLException e) {
			logger.info(e.getMessage());
		}
		String url = "";
		if (empList.size() != 0) {
			request.setAttribute("empList", empList);
			request.setAttribute("deptInfo", dept);
			url = "/department.jsp";
		} else {
			request.setAttribute("msg", "user doesn't exists with the given ID " + deptId);
		}
		rDispatcher = request.getRequestDispatcher(url);
		rDispatcher.forward(request, response);

	}

}
