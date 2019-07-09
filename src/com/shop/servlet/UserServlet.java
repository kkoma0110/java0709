package com.shop.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.po.User;
import com.shop.service.ServiceFactory;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/userServlet.do")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method=request.getParameter("method");
		if(method==null||method.equals("findAll")){
			findAll(request,response);
		}else if(method.equals("add")){
			add(request,response);
		}else if(method.equals("edit")){
			edit(request,response);
		}else if(method.equals("delete")){
			delete(request,response);
		}else if(method.equals("getUser")){
			getUser(request,response);
		}
	}

	private void getUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int uid=Integer.parseInt(request.getParameter("uid"));
		User u=ServiceFactory.getUserService().findOne(uid);		
		request.setAttribute("user", u);
		request.getRequestDispatcher("editUser.jsp").forward(request, response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int uid=Integer.parseInt(request.getParameter("uid"));
		ServiceFactory.getUserService().delete(uid);
		response.sendRedirect("userServlet.do");
		
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int uid=Integer.parseInt(request.getParameter("uid"));
		String uname=request.getParameter("uname");
		String password=request.getParameter("password");
		User u=new User(uid, uname, password);
		ServiceFactory.getUserService().update(u);
		response.sendRedirect("userServlet.do");
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String uname=request.getParameter("uname");
		String password=request.getParameter("password");
		User u=new User();
		u.setUname(uname);
		u.setPassword(password);
		ServiceFactory.getUserService().save(u);
		response.sendRedirect("userServlet.do");
		
	}

	private void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> us=ServiceFactory.getUserService().findAll();
		request.setAttribute("users", us);
		request.getRequestDispatcher("userList.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
