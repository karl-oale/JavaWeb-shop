package com.shop.servlet.cate;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.entity.SHOP_CATE;
import com.shop.server.SHOP_CATEDao;




/**
 * Servlet implementation class DoCateAdd
 */
@WebServlet("/manage/admin_docateadd")
public class DoCateAdd extends HttpServlet {

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
	
		
		String cateName = request.getParameter("cateName");
		
		int cateParent = Integer.parseInt(request.getParameter("cateParent")); 
		
		
		SHOP_CATE cate = new SHOP_CATE(0, cateName, cateParent);
		
		int count = SHOP_CATEDao.cateadd(cate);
		
		if (count>0) {
			response.sendRedirect("/shop/manage/admin_docateselect");
		}
		else {
			PrintWriter out = response.getWriter();
			out.write("<script>");
			out.write("alert('分类添加失败！');");
			out.write("location.href='manage/amdin_addcate.jsp'");
			out.write("</script>");
			out.close();
		}
	}

}
