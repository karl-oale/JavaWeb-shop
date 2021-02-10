package com.shop.servlet.prod;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.server.SHOP_PRODDao;

/**
 * Servlet implementation class DoProdDel
 */
@WebServlet("/manage/admin_doproddel")
public class DoProdDel extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		String cpage = request.getParameter("cpage");
		
		int count = SHOP_PRODDao.del(id);
		
		//成功或失败后的定向
		if (count > 0) {
			response.sendRedirect("/shop/manage/admin_doprodselect?cp="+cpage);
		}
		else {
			PrintWriter out = response.getWriter();
			out.write("<script>");
			out.write("alert('用户删除失败！')");
			out.write("location.href='manage/amdin_doprodselect?cp="+cpage);
			out.write("</script>");
			out.close();
		}
	}


}
