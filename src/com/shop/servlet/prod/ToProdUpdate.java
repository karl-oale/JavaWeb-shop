package com.shop.servlet.prod;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.entity.SHOP_CATE;
import com.shop.entity.SHOP_ORDER;
import com.shop.entity.SHOP_PROD;
import com.shop.server.SHOP_CATEDao;
import com.shop.server.SHOP_ORDERDao;
import com.shop.server.SHOP_PRODDao;

/**
 * Servlet implementation class ToProdUpdate
 */
@WebServlet("/manage/admin_toprodupdate")
public class ToProdUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		int pid = Integer.parseInt(request.getParameter("pid"));
		
		SHOP_PROD prod = SHOP_PRODDao.selectById(pid);
		ArrayList<SHOP_CATE> catelist = SHOP_CATEDao.selectall();
		
		request.setAttribute("prod", prod);
		request.setAttribute("cpage", request.getParameter("cpage"));
		request.setAttribute("catelist", catelist);
		request.getRequestDispatcher("admin_updateprod.jsp").forward(request, response);
		
	}

	

}
