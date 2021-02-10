package com.shop.dao;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//加载驱动
public class Basedao {
	static {
		
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	//链接本地数据库
	public static Connection getConnection() {
		
		Connection conn = null;
		
//		String url = "jdbc:mysql://localhost:3306/shop?useSSL=flase&serverTimezone=CST" ;     
//	    String username = "root" ;    
//	    String password = "1234567" ;   
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop?serverTimezone=CST" ,"root","oale1105..");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static int exectuIUD(String sql,Object[] params) {
		int count=0;
		
		Connection conn = Basedao.getConnection();
		
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(sql);
			
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i+1, params[i]);
			}
			
			count = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(null,ps,conn);
		}

		return count;
	}
	
	public static void closeall(ResultSet rs,PreparedStatement ps,Connection conn) {
		
		try {
			if (rs != null) {
				rs.close();
			}
			
			if (ps != null) {
				ps.close();
			}
			
			if (conn != null) {
				conn.close();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
