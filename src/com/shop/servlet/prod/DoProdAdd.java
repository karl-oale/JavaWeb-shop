package com.shop.servlet.prod;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.shop.entity.SHOP_PROD;
import com.shop.server.SHOP_PRODDao;

/**
 * Servlet implementation class DoProdAdd
 */
@WebServlet("/manage/admin_doprodadd")
public class DoProdAdd extends HttpServlet {
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//创建smartupload对象
				SmartUpload p = new SmartUpload();
				
				
				//初始化对象
				p.initialize(this.getServletConfig(), request, response);
				
				//上传对象
				
				try {
					p.upload();
				} catch (ServletException | IOException | SmartUploadException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				//获取上传对象
				Files fs = p.getFiles();
				File f = fs.getFile(0);
				
				String fname = new String( f.getFileName().getBytes(),"UTF-8");;
				String path = this.getServletContext().getRealPath("/");
				path = path + fname;
				
					
				try {
					/* f.saveAs("img/product/"+fname, p.SAVE_VIRTUAL); */
					
					 p.save("/img",p.SAVE_VIRTUAL); 
				} catch ( IOException | SmartUploadException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				
				
				
				System.out.println(fname);
				Request req = p.getRequest();
				
				String prodname = new String( req.getParameter("prodname").getBytes(),"UTF-8");;
				int prodpr = Integer.parseInt(req.getParameter("prodpr"));
				int prodstk = Integer.parseInt(req.getParameter("prodstk"));
				String proddesc = new String( req.getParameter("proddesc").getBytes(),"UTF-8");;
				String prodfcid = req.getParameter("prodfcid");
				int prodfid = Integer.parseInt(prodfcid.split(",")[0]);
				int prodcid = Integer.parseInt(prodfcid.split(",")[1]);
				
				//测试输出字格式
				/*
				 * 
				 * System.out.println(prodcid+"+"+prodname+"+"+prodpr+"+"+prodstk+"+"+proddesc+
				 * "+"+prodfid+"+"+prodcid);
				 */				
				SHOP_PROD prod = new SHOP_PROD(0, prodname, prodpr, proddesc, prodstk, prodfid, prodcid, fname);
				
				int count = SHOP_PRODDao.add(prod);
				
				if (count>0) {
					response.sendRedirect("/shop/manage/admin_doprodselect");
				}
				else {
					PrintWriter out = response.getWriter();
					out.write("<script>");
					out.write("alert('商品添加失败！');");
					out.write("location.href='/shop/manage/amdin_toaddprod'");
					out.write("</script>");
					out.close();
				}
		
		
	}

}
