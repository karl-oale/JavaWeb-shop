package com.shop.server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.shop.dao.Basedao;
import com.shop.entity.SHOP_CATE;

public class SHOP_CATEDao {

	

	public static ArrayList<SHOP_CATE> selectall() {
		// TODO Auto-generated method stub
		ArrayList<SHOP_CATE> list = new ArrayList<SHOP_CATE>();
		
		ResultSet rs = null;

		Connection conn = Basedao.getConnection();

		PreparedStatement ps = null;
		
		
		try {
			String sql = "select * from shop_cate order by CATE_ID  ";
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				SHOP_CATE u = new SHOP_CATE(
						rs.getInt("CATE_ID"), 
						rs.getString("CATE_NAME"),
						rs.getInt("CATE_PARENT"));
				list.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		return list;
	}

	public static int cateadd(SHOP_CATE cate) {
		String sql = "insert into shop_cate value( null, ?, ?)";

		Object[] params = { cate.getCATE_NAME(),cate.getCATE_PARENT() };

		return Basedao.exectuIUD(sql, params);
	}

	public static SHOP_CATE selectById(int id) {
		// TODO Auto-generated method stub
		SHOP_CATE cate = null;
		
		ResultSet rs = null;

		Connection conn = Basedao.getConnection();

		PreparedStatement ps = null;
		
		
		
		try {
			String sql = "select * from shop_cate where CATE_ID=?  ";
			
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				cate = new SHOP_CATE(
						rs.getInt("CATE_ID"), 
						rs.getString("CATE_NAME"),
						rs.getInt("CATE_PARENT"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cate;
	}

	public static int update(SHOP_CATE cate) {
		// TODO Auto-generated method stub
		
		String sql = "update shop_cate set CATE_NAME=?,CATE_PARENT=? where CATE_ID=?  ";
			
		Object[] params = {cate.getCATE_NAME(),cate.getCATE_PARENT(),cate.getCATE_ID()};
			
		
		return Basedao.exectuIUD(sql, params);
	}

	public static int del(int id) {
		// TODO Auto-generated method stub
		String sql = "delete from shop_cate where CATE_ID=?  ";
		Object[] params = {id};
		
		return Basedao.exectuIUD(sql, params);
	}

	
	
}
