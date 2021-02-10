package com.shop.servlet.front;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.entity.SHOP_CATE;
import com.shop.entity.SHOP_PROD;
import com.shop.server.SHOP_CATEDao;
import com.shop.server.SHOP_PRODDao;

/**
 * Servlet implementation class ToProdDetail
 */
@WebServlet("/toproddetail")
public class ToProdDetail extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		int  pid = Integer.parseInt(request.getParameter("pid"));
		
		SHOP_PROD prod = SHOP_PRODDao.selectById(pid);
		ArrayList<SHOP_CATE> catelist = SHOP_CATEDao.selectall();
		
		request.setAttribute("catelist", catelist);
		
		request.setAttribute("p", prod);
		request.getRequestDispatcher("proddetail.jsp").forward(request,response);
		
	}


}
