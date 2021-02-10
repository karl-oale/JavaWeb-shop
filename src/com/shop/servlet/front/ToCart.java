package com.shop.servlet.front;

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
import com.shop.entity.SHOP_USER;
import com.shop.server.SHOP_CATEDao;
import com.shop.server.SHOP_ORDERDao;

/**
 * Servlet implementation class ToCart
 */
@WebServlet("/tocart")
public class ToCart extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		HttpSession session = request.getSession();
		String isLogin = (String)session.getAttribute("isLogin");
		SHOP_USER userLogin = (SHOP_USER)session.getAttribute("userLogin");
		
		if (userLogin != null && isLogin.equals("1")) {
			String uid = userLogin.getUSER_ID();
			ArrayList<SHOP_ORDER> cartlist = SHOP_ORDERDao.selectByUid(uid,0);
			ArrayList<SHOP_CATE> catelist = SHOP_CATEDao.selectall();
			
			request.setAttribute("catelist", catelist);
			request.setAttribute("cartlist", cartlist);
			
			
			
			request.getRequestDispatcher("cart.jsp").forward(request, response);
		}
		else {
			PrintWriter out = response.getWriter();
			out.write("<script>");
			out.write("alert('ÇëÏÈµÇÂ¼£¡');");
			out.write("location.href='login.jsp'");
			out.write("</script>");
			out.close();
		}
		
		
		
		
	}


}
