package com.shop.servlet;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.shop.po.Type;
import com.shop.service.ServiceFactory;


/**
 * Servlet implementation class TypeServlet
 */
@WebServlet("/typeServlet.do")
public class TypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TypeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		String method =request.getParameter("method");
		
		if(method==null||method.equals("findAll")){
			findAll(request,response);
		}else if(method.equals("add")){
			add(request,response);
		}else if(method.equals("delete")){
			delete(request,response);
		}else if(method.equals("edit")){
			edit(request,response);
		}else if(method.equals("change")){
			change(request,response);
		}
		
		
	}

	
	
	private void change(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		Type type = new Type();
		Type type2 = new Type() ;
		try {
			List<FileItem>  items = upload.parseRequest(request);
			for(FileItem item:items){
				if(item.isFormField()){
					String fieleName = item.getFieldName();
					if(fieleName.equals("tname")){
						type.setTname(item.getString("utf-8"));
					}else if(fieleName.equals("tdesc")){
						type.setTdesc(item.getString("utf-8"));
					}else if(fieleName.equals("tid")){
						type.setTid(Integer.parseInt(item.getString("utf-8")));
						type2 = ServiceFactory.getTypeService().findById(type.getTid());
					}
					
				}else{
					String fileName = item.getName();
					if(!fileName.equals("")){
						String hz = fileName.substring(fileName.lastIndexOf("."));
						File dir = new File(request.getRealPath("/upload/"));
						
						if(!dir.exists()){
							dir.mkdirs();
						}
						
						String oldName = type2.getTphoto();
						File old = new File(dir.getParentFile(),oldName);
						
						if(old.exists()){
							old.delete();
						}
						
						String str = UUID.randomUUID()+hz;
						type.setTphoto("upload"+File.separator+str);
						File targetFile = new File(dir, str);
						item.write(targetFile);
					}
				}
			}
			
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(type.getTphoto()==null){
			type.setTphoto(type2.getTphoto());
		}
		
		ServiceFactory.getTypeService().update(type);
		response.sendRedirect("typeServlet.do");
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int tid = Integer.parseInt(request.getParameter("tid"));
		Type type = ServiceFactory.getTypeService().findById(tid);
		
		request.setAttribute("type", type);
		request.getRequestDispatcher("editType.jsp").forward(request, response);;
		
	}

	
	
	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int tid = Integer.parseInt(request.getParameter("tid"));
		
		ServiceFactory.getTypeService().deleteByTid(tid);
		response.sendRedirect("typeServlet.do");
	}

	
	
	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		Type type = new Type();
		
		try {
			List<FileItem> items = upload.parseRequest(request);
			for(FileItem item:items){
				if(item.isFormField()){
					String fieleName = item.getFieldName();
					if(fieleName.equals("tname")){
						type.setTname(item.getString("utf-8"));
					}else if(fieleName.equals("tdesc")){
						type.setTdesc(item.getString("utf-8"));
					}
				}else{
					String fileName = item.getName();
					String hz = fileName.substring(fileName.lastIndexOf("."));
					
					String dir = request.getRealPath("/upload/");
					
					File dirFile = new File(dir);
					if(!dirFile.exists()){
						dirFile.mkdirs();
					}
					String fName = UUID.randomUUID().toString();
					
					type.setTphoto("upload"+File.separator+fName+hz);
					File targetFile = new File(dirFile, fName+hz);
					item.write(targetFile);
					
				}
			}
			
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ServiceFactory.getTypeService().addType(type);
		response.sendRedirect("typeServlet.do");
		
	}

	
	
	private void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<Type> typeList = ServiceFactory.getTypeService().findAllType();
		
		request.setAttribute("typeList", typeList);
		
		request.getRequestDispatcher("typeList.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
