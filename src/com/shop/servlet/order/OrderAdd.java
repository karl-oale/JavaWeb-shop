package com.shop.servlet.order;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.shop.entity.SHOP_ORDER;
import com.shop.entity.SHOP_PROD;
import com.shop.entity.SHOP_USER;
import com.shop.server.SHOP_ORDERDao;
import com.shop.server.SHOP_PRODDao;

/**
 * Servlet implementation class OrderAdd
 */
@WebServlet("/orderadd")
public class OrderAdd extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		
		int pid= Integer.parseInt(request.getParameter("pid"));
		int num = Integer.parseInt(request.getParameter("num"));
		int type = Integer.parseInt(request.getParameter("type"));
		
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
			
			
			SHOP_ORDER exsit = SHOP_ORDERDao.selectByPidUid(pid,uid,0);
			
			if (exsit == null) {
				SHOP_ORDER order = new SHOP_ORDER(0, pid, pname, ppr, num, pstk, pfname, uid, uadr, type);
				
				int count = SHOP_ORDERDao.add(order);
				
				
				if (count > 0) {
					
					PrintWriter out = response.getWriter(); out.write("<script>");
					 out.write("alert('Ìí¼Ó³É¹¦£¡');"); //
					 out.write("history.go(-1)"); 
					 out.write("</script>");
					 out.close();
					 
//					String url = "toproddetail?pid="+pid;
//					response.sendRedirect(url);
				}else {
					PrintWriter out = response.getWriter();
					out.write("<script>");
					out.write("alert('Ìí¼ÓÊ§°Ü£¡');");
					out.write("</script>");
					out.close();
					String url = "toproddetail?pid="+pid;
					response.sendRedirect(url);
				}
			}
			else {
				num=num+exsit.getORDER_PNUM();
				int ret = SHOP_ORDERDao.updateByNum(pid,uid,num,0);
				
				if (ret > 0) {
					
					PrintWriter out = response.getWriter(); out.write("<script>");
					 out.write("alert('Ìí¼Ó³É¹¦£¡');"); //
					 out.write("history.go(-1)"); 
					 out.write("</script>");
					 out.close();
					 
//					String url = "toproddetail?pid="+pid;
//					response.sendRedirect(url);
				}else {
					PrintWriter out = response.getWriter();
					out.write("<script>");
					out.write("alert('Ìí¼ÓÊ§°Ü£¡');");
					out.write("</script>");
					out.close();
					String url = "toproddetail?pid="+pid;
					response.sendRedirect(url);
				}
				
			}
			
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
