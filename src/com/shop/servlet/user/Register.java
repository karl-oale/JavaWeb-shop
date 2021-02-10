package com.shop.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.entity.SHOP_USER;
import com.shop.server.SHOP_USERDao;

/**
 * Servlet implementation class Register
 */
@WebServlet("/register")
public class Register extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String nsername = request.getParameter("userName");
		String name = request.getParameter("name");
		String pwd = request.getParameter("passWord");
		String sex = request.getParameter("sex");
		String year = request.getParameter("birthday");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String address = request.getParameter("address");
		
		SHOP_USER user_add = new SHOP_USER(nsername, name, pwd, sex, year, email, mobile, address, 1);
		
		//���뵽���ݿ���û���
		int count = SHOP_USERDao.insert(user_add);
		//System.out.print(count);
		//�ɹ���ʧ�ܺ�Ķ���
		if (count > 0) {
			response.sendRedirect("login.jsp");
		}
		else {
			PrintWriter out = response.getWriter();
			out.write("<script>");
			out.write("alert('�û�ע��ʧ�ܣ�');");
			out.write("location.href='reg.jsp'");
			out.write("</script>");
			
		}
		
	}
	

}
