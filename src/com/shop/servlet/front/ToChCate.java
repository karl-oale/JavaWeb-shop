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
 * Servlet implementation class ToChCate
 */
@WebServlet("/tochcate")
public class ToChCate extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		int  fid = Integer.parseInt(request.getParameter("fid"));
		int cid = Integer.parseInt(request.getParameter("cid"));
		
		ArrayList<SHOP_PROD> prodlist = SHOP_PRODDao.selectByFidCid(fid,cid);
		ArrayList<SHOP_CATE> catelist = SHOP_CATEDao.selectall();
		
		request.setAttribute("catelist", catelist);
		request.setAttribute("prodlist", prodlist);
		request.setAttribute("fid", fid);
		request.setAttribute("cid", cid);
		
		request.getRequestDispatcher("showchprod.jsp").forward(request,response);
	}

}
