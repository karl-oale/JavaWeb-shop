package com.shop.servlet.prod;

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
 * Servlet implementation class DoProdSelect
 */
@WebServlet("/manage/admin_doprodselect")
public class DoProdSelect extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		int cpage=1;
		int count=8;
		
		String cp = request.getParameter("cp");
		String keyword = request.getParameter("keywords");
		//String searchword = request.getParameter("keywords");
		
		if (cp != null) {
			cpage = Integer.parseInt(cp);
		
		}
		int arr[] = SHOP_PRODDao.totalpage(count,keyword);
		
		ArrayList<SHOP_PROD> prodlist = SHOP_PRODDao.select(cpage,count,keyword);
		
		ArrayList<SHOP_CATE> catelist = SHOP_CATEDao.selectall();
		
		request.setAttribute("prodlist", prodlist);
		request.setAttribute("tsum", arr[0]);
		request.setAttribute("tpage", arr[1]);
		request.setAttribute("cpage", cpage);
		
		request.setAttribute("catelist", catelist);
		
		
		if (keyword !=null) {
			
			request.setAttribute("searchword", "&keywords="+keyword);
		}
		
		request.getRequestDispatcher("admin_prod.jsp").forward(request,response);
		
		
	}

	

}
