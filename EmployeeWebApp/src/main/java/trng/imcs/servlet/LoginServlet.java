package trng.imcs.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import imcs.core.service.EmployeeService;
import imcs.core.serviceImpl.EmployeeServiceImpl;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rDispatcher;
		String url = null;
		String username = request.getParameter("form-username");
		String password = request.getParameter("form-password");
		System.out.println("entered login");
		EmployeeService es = new EmployeeServiceImpl();
		boolean status = es.validateUser(username, password);
		if(status==true) {
			url = "/empHome.jsp";
			request.getSession().setAttribute("username", username);
			rDispatcher = request.getRequestDispatcher(url);
			rDispatcher.forward(request, response);
		}
		
		url = "/welcome.jsp";
		request.setAttribute("msg", "Enter Valid Credentials");
		rDispatcher = request.getRequestDispatcher(url);
		rDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rDispatcher;
		request.getSession().invalidate();
		String url = "/welcome.jsp";
		rDispatcher = request.getRequestDispatcher(url);
		rDispatcher.forward(request, response);
		
	}

}
