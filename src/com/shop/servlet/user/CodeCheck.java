package com.shop.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CodeCheck
 */
@WebServlet("/codecheck")
public class CodeCheck extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String incode = request.getParameter("incode");
		
		HttpSession session = request.getSession();
		String tcode = (String)session.getAttribute("code");
		
		PrintWriter out = response.getWriter();
		if (tcode.equals(incode)) {
			out.print("ture");
		}else {
			out.print("flase");
		}
		out.close();
		
	}

}
