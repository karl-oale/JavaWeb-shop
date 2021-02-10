package com.shop.servlet.order;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.entity.SHOP_ORDER;
import com.shop.entity.SHOP_USER;
import com.shop.server.SHOP_ORDERDao;
import com.shop.server.SHOP_USERDao;

/**
 * Servlet implementation class DoOrderSelect
 */
@WebServlet("/manage/admin_doorderselect")
public class DoOrderSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int cpage = 1;
		int count = 8;
		
		String cp = request.getParameter("cp");
		String keyword = request.getParameter("keywords");
		//String searchword = request.getParameter("keywords");
		
		if (cp != null) {
			cpage = Integer.parseInt(cp);
		
		}
		
		int arr[] = SHOP_ORDERDao.totalpage(count,keyword);
		
		
		
		ArrayList<SHOP_ORDER> list = SHOP_ORDERDao.selectall(cpage,count,keyword);
		
		request.setAttribute("orderlist", list);
		request.setAttribute("tsum", arr[0]);
		request.setAttribute("tpage", arr[1]);
		request.setAttribute("cpage", cpage);
		
		
		if (keyword !=null) {
			
			request.setAttribute("searchword", "&keywords="+keyword);
		}
		
		
		request.getRequestDispatcher("admin_order.jsp").forward(request, response);
	}

	

}
