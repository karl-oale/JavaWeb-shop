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
 * Servlet implementation class DoCateUpdate
 */
@WebServlet("/manage/admin_docateupdate")
public class DoCateUpdate extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		int id=Integer.parseInt(request.getParameter("cateId"));
		String name = request.getParameter("cateName");
		int parent=Integer.parseInt(request.getParameter("cateParent"));
		
		System.out.println(name);
		
		SHOP_CATE cate = new SHOP_CATE(id, name, parent);
		System.out.println(cate.getCATE_ID()+"+"+cate.getCATE_NAME()+"+"+cate.getCATE_PARENT());
		int count = SHOP_CATEDao.update(cate);
		
		
		
		if (count > 0) {
			response.sendRedirect("/shop/manage/admin_docateselect");
		}
		else {
			PrintWriter out = response.getWriter();
			out.write("<script>");
			out.write("alert('分类更新失败！');");
			out.write("location.href='manage/amdin_tocateupdate'");
			out.write("</script>");
			
		}
	}

}
