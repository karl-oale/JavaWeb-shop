package com.shop.servlet.order;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.server.SHOP_ORDERDao;


/**
 * Servlet implementation class DoOrderDel
 */
@WebServlet("/manage/admin_doorderdel")
public class DoOrderDel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		int cpage=1;
		int oid = Integer.parseInt(request.getParameter("oid"));
		String cp = request.getParameter("cp");
		if (cp!=null) {
			cpage = Integer.parseInt(cp);
			
		}
		System.out.println(oid);
		int count = SHOP_ORDERDao.del(oid);
		
		if (count > 0) {
			response.sendRedirect("/shop/manage/admin_doorderselect?cp="+cpage);
		}
		else {
			PrintWriter out = response.getWriter();
			out.write("<script>");
			out.write("alert('ÓÃ»§É¾³ýÊ§°Ü£¡')");
			out.write("location.href='/shop/manage/admin_doorderselect");
			out.write("</script>");
			out.close();
		}
	}
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		int cpage=1;
		
		String ids[] = request.getParameterValues("id[]");
		String cp = request.getParameter("cp");
		if (cp!=null) {
			cpage = Integer.parseInt(cp);
			
		}
		/* System.out.println(cp); */
		int count=1;
		
		for (int i = 0; i < ids.length; i++) {
			count *= SHOP_ORDERDao.del(Integer.parseInt(ids[i]));
		}
		if (count !=0) {
			response.sendRedirect("/shop/manage/admin_doorderselect?cp="+cpage);
		}
		
		else {
			PrintWriter out = response.getWriter();
			out.write("<script>");
			out.write("alert('¶©µ¥É¾³ýÊ§°Ü£¡');");
			out.write("location.href='amdin_doorderselect");
			out.write("</script>");
			
		}
	}
	
}
