package com.shop.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.po.User;
import com.shop.service.ServiceFactory;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/login.do")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		if(method == null) {
			method = "login";
		}
		switch(method) {
		case "login":
		default:
			login(request, response);
			break;
		case "reg":
			reg(request, response);
			break;
		case "out":
			out(request, response);
			break;
		}
	}

	private void out(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ServiceFactory.getUserService().out(request);
		response.getWriter().write("true");
		response.getWriter().close();
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String uname = request.getParameter("uname");
		String password = request.getParameter("password");
		String returnStr = ServiceFactory.getUserService().login(uname, password, request);
		response.getWriter().write(returnStr);
		response.getWriter().close();
	}

	private void reg(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String uname = request.getParameter("uname");
		String password = request.getParameter("password");
		User newUser = new User();
		newUser.setUname(uname);
		newUser.setPassword(password);
		ServiceFactory.getUserService().save(newUser);
		response.getWriter().write("true");
		response.getWriter().close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
