package com.shop.servlet.prod;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.entity.SHOP_CATE;
import com.shop.server.SHOP_CATEDao;

/**
 * Servlet implementation class ToAddProd
 */
@WebServlet("/manage/admin_toaddprod")
public class ToAddProd extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		
		ArrayList<SHOP_CATE> catelist = SHOP_CATEDao.selectall(); 
		
		
		
		request.setAttribute("catelist", catelist); 
		
		
		request.getRequestDispatcher("admin_addprod.jsp").forward(request,response);
		 
		
	}


}
