package com.shop.servlet.cate;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.entity.SHOP_CATE;
import com.shop.server.SHOP_CATEDao;

/**
 * Servlet implementation class DoCateDel
 */
@WebServlet("/manage/admin_docatedel")
public class DoCateDel extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		int flag=1;
		int id=Integer.parseInt(request.getParameter("id"));
		
		ArrayList<SHOP_CATE> list = SHOP_CATEDao.selectall();
		
		for (SHOP_CATE catedel : list) {
			
			if (catedel.getCATE_PARENT() == 0 && catedel.getCATE_ID() == id) {
				for (SHOP_CATE xcatedel : list) {
					if (xcatedel.getCATE_PARENT() == catedel.getCATE_ID()) {
						flag=0;
					}
				}
			}
		}
		
		
		if (flag==1) {
			int count = SHOP_CATEDao.del(id);
			
			if (count > 0) {
				response.sendRedirect("/shop/manage/admin_docateselect");
			}
			else {
				PrintWriter out = response.getWriter();
				out.write("<script>");
				out.write("alert('分类删除失败！');");
				out.write("location.href='amdin_docateselect'");
				out.write("</script>");
				out.close();
			}
		}
		else {
			PrintWriter out = response.getWriter();
			out.write("<script>");
			out.write("alert('父类删除只支持删除没有子类的父类，该父类不符合条件！');");
			out.write("location.href='admin_docateselect'");
			out.write("</script>");
			out.close();
		}
		
		
	}

	

}
