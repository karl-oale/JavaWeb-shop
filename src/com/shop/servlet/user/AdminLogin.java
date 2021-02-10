package com.shop.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.entity.SHOP_USER;
import com.shop.server.SHOP_USERDao;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/manage/adminlogin")
public class AdminLogin extends HttpServlet {


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String name = request.getParameter("userName");
		String password = request.getParameter("passWord");
		
		int count = SHOP_USERDao.selectByNP(name,password);
		
		if (count > 0) {
			HttpSession session = request.getSession();
			SHOP_USER user = SHOP_USERDao.selectUser(name,password);
			
			session.setAttribute("userLogin", user);
			session.setAttribute("isLogin", "1");
			
			if (user.getUSER_STATUS() == 2) {
				session.setAttribute("isAdminLogin", "1");
				response.sendRedirect("admin_index.jsp");
			}
			else {
				response.sendRedirect("/shop/indexcate");
			}
			
			
			}
		else {
			PrintWriter out = response.getWriter();
			out.write("<script>");
			out.write("alert('用户名称或密码错误！');");
			out.write("location.href='/shop/manage/admin_login.jsp'");
			out.write("</script>");
			out.close();
		}
	}

}
