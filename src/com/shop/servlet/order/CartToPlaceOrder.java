package com.shop.servlet.order;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.entity.SHOP_CATE;
import com.shop.entity.SHOP_ORDER;
import com.shop.server.SHOP_CATEDao;
import com.shop.server.SHOP_ORDERDao;

/**
 * Servlet implementation class CartToPlaceOrder
 */
@WebServlet("/carttoplaceorder")
public class CartToPlaceOrder extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
				
		String[] ids = request.getParameterValues("id[]");
		
		float tpr = 0;
		int count=1;
		
		ArrayList<SHOP_ORDER> list = new ArrayList<SHOP_ORDER>();
		ArrayList<SHOP_CATE> catelist = SHOP_CATEDao.selectall();
		
		for (int i = 0; i < ids.length; i++) {
			SHOP_ORDER order = SHOP_ORDERDao.selectById(Integer.parseInt(ids[i]));
			if (order == null) {
				count = -1;
			}
			tpr = tpr + order.getORDER_PNUM()*order.getORDER_PPR();
			list.add(order);
		}
		
		if (count >0) {
			String tprice = Float.toString(tpr);
			
			
			request.setAttribute("catelist", catelist);
			request.setAttribute("orderlist", list);
			request.setAttribute("tpr", tprice);
			request.setAttribute("isExsit", "1");
			
			request.getRequestDispatcher("placeorder.jsp").forward(request, response);
		}
		
		else {
			PrintWriter out = response.getWriter();
			out.write("<script>");
			out.write("alert('½¨Á¢¶©µ¥Ê§°Ü£¡');");
			out.write("location.href='tocart'");
			out.write("</script>");
			
		}
		
		
		
	}


}
