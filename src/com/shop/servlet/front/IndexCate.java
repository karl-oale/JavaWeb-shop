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
 * Servlet implementation class IndexCate
 */
@WebServlet("/indexcate")
public class IndexCate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		ArrayList<SHOP_CATE> catelist = SHOP_CATEDao.selectall();
		ArrayList<SHOP_PROD> prodlist = SHOP_PRODDao.selectall();
		
		request.setAttribute("catelist", catelist);
		request.setAttribute("prodlist", prodlist);
		
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	

}
