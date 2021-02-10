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
 * Servlet implementation class ToOrderDel
 */
@WebServlet("/toorderdel")
public class ToOrderDel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		int oid = Integer.parseInt(request.getParameter("oid"));
		System.out.println(oid);
		int count = SHOP_ORDERDao.del(oid);
		
		if (count > 0) {
			response.sendRedirect("tocart");
		}
		else {
			PrintWriter out = response.getWriter();
			out.write("<script>");
			out.write("alert('ÓÃ»§É¾³ýÊ§°Ü£¡')");
			out.write("location.href='tocart");
			out.write("</script>");
			out.close();
		}
	}


}
