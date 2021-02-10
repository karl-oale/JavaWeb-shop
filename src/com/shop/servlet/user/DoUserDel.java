package com.shop.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.entity.SHOP_USER;
import com.shop.server.SHOP_USERDao;

/**
 * Servlet implementation class DoUserDel
 */
@WebServlet("/manage/admin_douserdel")
public class DoUserDel extends HttpServlet {
	
	
	//删除单个用户用到
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String id = request.getParameter("id");
		
		String cpage = request.getParameter("cpage");
		

		//加入到数据库的用户表
		int count = SHOP_USERDao.delete(id);
		//System.out.print(count);
		
		
		//成功或失败后的定向
		if (count > 0) {
			response.sendRedirect("/shop/manage/admin_douserselect?cp="+cpage);
		}
		else {
			PrintWriter out = response.getWriter();
			out.write("<script>");
			out.write("alert('用户删除失败！');");
			out.write("location.href='manage/amdin_douserselect?cp="+cpage);
			out.write("</script>");
			
		}
	}

	
	
	//批量删除用户用到
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String ids[] = request.getParameterValues("id[]");
		
		
		int count=1;
		
		
		for (int i = 0; i < ids.length; i++) {
			count *= SHOP_USERDao.delete(ids[i]);
			
		}
		if (count !=0) {
			response.sendRedirect("/shop/manage/admin_douserselect");
		}
		
		else {
			PrintWriter out = response.getWriter();
			out.write("<script>");
			out.write("alert('用户删除失败！');");
			out.write("location.href='amdin_douserselect");
			out.write("</script>");
			
		}
	}

}
