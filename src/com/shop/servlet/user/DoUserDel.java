package com.shop.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.entity.SHOP_USER;
import com.shop.server.SHOP_USERDao;

/**
 * Servlet implementation class DoUserDel
 */
@WebServlet("/manage/admin_douserdel")
public class DoUserDel extends HttpServlet {
	
	
	//ɾ�������û��õ�
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String id = request.getParameter("id");
		
		String cpage = request.getParameter("cpage");
		

		//���뵽���ݿ���û���
		int count = SHOP_USERDao.delete(id);
		//System.out.print(count);
		
		
		//�ɹ���ʧ�ܺ�Ķ���
		if (count > 0) {
			response.sendRedirect("/shop/manage/admin_douserselect?cp="+cpage);
		}
		else {
			PrintWriter out = response.getWriter();
			out.write("<script>");
			out.write("alert('�û�ɾ��ʧ�ܣ�');");
			out.write("location.href='manage/amdin_douserselect?cp="+cpage);
			out.write("</script>");
			
		}
	}

	
	
	//����ɾ���û��õ�
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String ids[] = request.getParameterValues("id[]");
		
		
		int count=1;
		
		
		for (int i = 0; i < ids.length; i++) {
			count *= SHOP_USERDao.delete(ids[i]);
			
		}
		if (count !=0) {
			response.sendRedirect("/shop/manage/admin_douserselect");
		}
		
		else {
			PrintWriter out = response.getWriter();
			out.write("<script>");
			out.write("alert('�û�ɾ��ʧ�ܣ�');");
			out.write("location.href='amdin_douserselect");
			out.write("</script>");
			
		}
	}

}
