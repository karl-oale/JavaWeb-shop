package com.shop.servlet.cate;

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
 * Servlet implementation class DoCateSelect
 */
@WebServlet("/manage/admin_docateselect")
public class DoCateSelect extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		ArrayList<SHOP_CATE> list = SHOP_CATEDao.selectall();
		
		request.setAttribute("catelist", list);
		
		
		request.getRequestDispatcher("admin_cate.jsp").forward(request, response);
	}

	
}
