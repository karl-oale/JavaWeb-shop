package com.shop.servlet.order;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.entity.SHOP_CATE;
import com.shop.entity.SHOP_ORDER;
import com.shop.entity.SHOP_PROD;
import com.shop.entity.SHOP_USER;
import com.shop.server.SHOP_CATEDao;
import com.shop.server.SHOP_PRODDao;

/**
 * Servlet implementation class ProdToPlaceOrder
 */
@WebServlet("/prodtoplaceorder")
public class ProdToPlaceOrder extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		int pid= Integer.parseInt(request.getParameter("pid"));
		int num = Integer.parseInt(request.getParameter("num"));
		
		HttpSession session = request.getSession();
		String isLogin = (String)session.getAttribute("isLogin");
		SHOP_USER userLogin = (SHOP_USER)session.getAttribute("userLogin");
		
		if (userLogin != null && isLogin.equals("1")) {
			SHOP_PROD prod = SHOP_PRODDao.selectById(pid);
			String pname = prod.getPROD_NAME();
			float ppr = prod.getPROD_PR();
			int pstk = prod.getPROD_STK();
			String pfname = prod.getPROD_FNAME();
			String uid = (String)userLogin.getUSER_ID();
			String uadr = (String)userLogin.getUSER_ADDRESS();
			
			SHOP_ORDER order = new SHOP_ORDER(0, pid, pname, ppr, num, pstk, pfname, uid, uadr, -1);
			
			float tpr= order.getORDER_PPR()*order.getORDER_PNUM();
			
			ArrayList<SHOP_CATE> catelist = SHOP_CATEDao.selectall();
			
			ArrayList<SHOP_ORDER> list = new ArrayList<SHOP_ORDER>();
			list.add(order);
			
			System.out.println(order.getORDER_PNAME());
			System.out.println(list.get(0).getORDER_PNAME());
			
			String tprice = Float.toString(tpr);
			
			
			request.setAttribute("catelist", catelist);
			request.setAttribute("isExsit", "0");
			request.setAttribute("orderlist", list);
			request.setAttribute("tpr", tprice);
			
			request.getRequestDispatcher("placeorder.jsp").forward(request, response);
			
			
		}else {
			PrintWriter out = response.getWriter();
			out.write("<script>");
			out.write("alert('ÇëÏÈµÇÂ¼£¡');");
			out.write("location.href='login.jsp'");
			out.write("</script>");
			out.close();
		}
	}

	

}
