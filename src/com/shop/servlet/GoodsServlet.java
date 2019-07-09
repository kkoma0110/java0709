package com.shop.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.po.Goods;
import com.shop.service.ServiceFactory;

/**
 * Servlet implementation class GoodsServlet
 */
@WebServlet("/goods.do")
public class GoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoodsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String method = req.getParameter("method");
		if(method==null||method.equals("findAll")){
			findAll(req,resp);
		}
		else if(method.equals("add")){
			add(req,resp);
		}
		else if(method.equals("updateForm")){
			updateForm(req,resp);
		}
		else if(method.equals("exit")){
			exit(req,resp);
		}
		else if(method.equals("delete")){
			delete(req,resp);
		}
	}

	private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub
		int gid = Integer.parseInt(req.getParameter("gid"));
		ServiceFactory.getGoodsService().delete(gid);
		resp.sendRedirect("goods.do");
	}

	private void exit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub
		int gid = Integer.parseInt(req.getParameter("gid"));
		String gname = req.getParameter("gname");
		String gprice = req.getParameter("gprice");
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		String gphoto = req.getParameter("gphoto");
		String gdesc = req.getParameter("gdesc");
		int gtype = Integer.parseInt(req.getParameter("gtype"));
		Goods g = new Goods(gid, gname, gprice, quantity, gphoto, gdesc, gtype);
		ServiceFactory.getGoodsService().update(g);
		resp.sendRedirect("goods.do");
		
	}

	private void updateForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int gid = Integer.parseInt(req.getParameter("gid"));
		Goods g = ServiceFactory.getGoodsService().findOne(gid);
		req.setAttribute("g", g);
		req.getRequestDispatcher("goodsUpdateForm.jsp").forward(req, resp);
		
	}

	private void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub
		String gname = req.getParameter("gname");
		String gprice = req.getParameter("gprice");
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		String gphoto = req.getParameter("gphoto");
		String gdesc = req.getParameter("gdesc");
		int gtype = Integer.parseInt(req.getParameter("gtype"));
		Goods g = new Goods(0, gname, gprice, quantity, gphoto, gdesc, gtype);
		ServiceFactory.getGoodsService().add(g);
		resp.sendRedirect("goods.do");
		
	}

	private void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Goods> gs = ServiceFactory.getGoodsService().findAll();
		req.setAttribute("gs", gs);
		req.getRequestDispatcher("goodsShowAll.jsp").forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
