package com.shop.servlet.front;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

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
 * Servlet implementation class ToFaCate
 */
@WebServlet("/tofacate")
public class ToFaCate extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		int  fid = Integer.parseInt(request.getParameter("fid"));
		
		ArrayList<SHOP_PROD> prodlist = SHOP_PRODDao.selectByFid(fid);
		ArrayList<SHOP_CATE> catelist = SHOP_CATEDao.selectall();
		
		/*
		 * for (SHOP_PROD p : prodlist) {
		 * System.out.println(p.getPROD_NAME()+"+"+p.getPROD_FID()+"+"+p.getPROD_CID());
		 * }
		 */
		
		request.setAttribute("catelist", catelist);
		request.setAttribute("prodlist", prodlist);
		request.setAttribute("fid", fid);
//		request.setAttribute("cid", null);
		
		request.getRequestDispatcher("showfaprod.jsp").forward(request,response);
	}


}
