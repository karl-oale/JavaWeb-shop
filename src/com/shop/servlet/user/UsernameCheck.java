package com.shop.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.dao.Basedao;
import com.shop.server.SHOP_USERDao;

/**
 * Servlet implementation class UsernameCheck
 */
@WebServlet("/usernamecheck")
public class UsernameCheck extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String name = request.getParameter("name");
		
		int count= SHOP_USERDao.selectByName(name);
		
		PrintWriter out = response.getWriter();
		if (count>0) {
			out.print("flase");
		}
		else {
			out.print("ture");
		}
		out.close();
	}

}
