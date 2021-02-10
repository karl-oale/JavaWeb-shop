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
 * Servlet implementation class ToCateUpdate
 */
@WebServlet("/manage/admin_tocateupdate")
public class ToCateUpdate extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		int id = Integer.parseInt(request.getParameter("id"));

		ArrayList<SHOP_CATE> catelist = SHOP_CATEDao.selectall(); 
		SHOP_CATE cate =SHOP_CATEDao.selectById(id);
		
		request.setAttribute("catelist", catelist); 
		request.setAttribute("cate",cate);
		
		request.getRequestDispatcher("admin_updatecate.jsp").forward(request,response);
		
	}

}
