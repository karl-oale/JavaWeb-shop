package com.shop.servlet.prod;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.entity.SHOP_PROD;
import com.shop.server.SHOP_PRODDao;

/**
 * Servlet implementation class DoProdUpdate
 */
@WebServlet("/manage/admin_doprodupdate")
public class DoProdUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		int pid = Integer.parseInt(request.getParameter("pid"));
		String pname = request.getParameter("prodname");
		float ppr = Float.parseFloat(request.getParameter("prodpr"));
		String pdesc = request.getParameter("proddesc");
		int pstk = Integer.parseInt(request.getParameter("prodstk"));
		String prodfcid = request.getParameter("prodfcid");
		
		int pfid = Integer.parseInt(prodfcid.split(",")[0]);
		int pcid = Integer.parseInt(prodfcid.split(",")[1]);
		
		String cpage = request.getParameter("cpage");
		String keyword = request.getParameter("keywords");
		
		String search = null;
		if (keyword != null) {
			
			search = "&keywords="+keyword;
		}
		
		SHOP_PROD prod = new SHOP_PROD(pid, pname, ppr, pdesc, pstk, pfid, pcid, null);
		
		System.out.println(prod.getPROD_ID()+"+"+
				prod.getPROD_NAME()+"+"+
				prod.getPROD_PR()+"+"+
				prod.getPROD_DESC()+"+"+
				prod.getPROD_FID()+"+"+
				prod.getPROD_CID()+"+"+
				prod.getPROD_FNAME());
		
		int count = SHOP_PRODDao.update(prod);
		
		if (count > 0) {
			response.sendRedirect("/shop/manage/admin_doprodselect?cp="+cpage+search);
		}
		else {
			PrintWriter out = response.getWriter();
			out.write("<script>");
			out.write("alert('商品更新失败！');");
			out.write("location.href='admin_toprodupdate?pid="+pid+"&cpage="+cpage+" ' ");
			out.write("</script>");
		}
		
		
	}

}
