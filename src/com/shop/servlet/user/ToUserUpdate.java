package com.shop.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.entity.SHOP_USER;
import com.shop.server.SHOP_USERDao;

/**
 * Servlet implementation class ToUserUpdate
 */
@WebServlet("/manage/admin_touserupdate")
public class ToUserUpdate extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String id = request.getParameter("id");
		
		
		
		SHOP_USER user = SHOP_USERDao.selectById(id);
		
		
		request.setAttribute("user", user);
		request.setAttribute("cpage", request.getParameter("cpage"));
		
		request.getRequestDispatcher("admin_modify.jsp").forward(request, response);
		
	}


}
