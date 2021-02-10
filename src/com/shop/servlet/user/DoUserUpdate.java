package com.shop.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.entity.SHOP_USER;
import com.shop.server.SHOP_USERDao;

/**
 * Servlet implementation class DoUserUpdate
 */
@WebServlet("/manage/admin_douserupdate")
public class DoUserUpdate extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String username = request.getParameter("username");
		String name = request.getParameter("name");
		String pwd = request.getParameter("password");
		String sex = request.getParameter("sex");
		String year = request.getParameter("birthday");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String address = request.getParameter("address");
		String userstatus = request.getParameter("userstatus");
		
		String cpage = request.getParameter("cpage");
		String keyword = request.getParameter("keywords");
		
		int status = 1;
		
		if (userstatus != null) {
			status = Integer.parseInt(userstatus);
		}
		
		String search = null;
		if (keyword != null) {
			System.out.println(keyword);
			search = "&keywords="+keyword;
		}
		
		SHOP_USER user_update = new SHOP_USER(username, name, pwd, sex, year, email, mobile, address, status);
		
		//加入到数据库的用户表
		int count = SHOP_USERDao.update(user_update);
		//System.out.print(count);
		
		
		//成功或失败后的定向
		if (count > 0) {
			response.sendRedirect("/shop/manage/admin_douserselect?cp="+cpage+search);
		}
		else {
			PrintWriter out = response.getWriter();
			out.write("<script>");
			out.write("alert('用户添加失败！');");
			out.write("location.href='manage/amdin_touserupdate?id="+username+" ' ");
			out.write("</script>");
			
		}
		
	}

}
