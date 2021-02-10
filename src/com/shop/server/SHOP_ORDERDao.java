package com.shop.server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.shop.dao.Basedao;
import com.shop.entity.SHOP_ORDER;

public class SHOP_ORDERDao {

	public static int add(SHOP_ORDER order) {
		// TODO Auto-generated method stub
		
		String sql = "insert into shop_order value( null, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		Object[] params = { 
				order.getORDER_PID(),
				order.getORDER_PNAME(),
				order.getORDER_PPR(),
				order.getORDER_PNUM(),
				order.getORDER_PSTK(),
				order.getORDER_PFNAME(),
				order.getORDER_UID(),
				order.getORDER_UADR(),
				order.getORDER_TYPE(),
				};

		return Basedao.exectuIUD(sql, params);
	}

	public static ArrayList<SHOP_ORDER> selectByUid(String uid,int type) {
		// TODO Auto-generated method stub
		ArrayList<SHOP_ORDER> list = new ArrayList<SHOP_ORDER>();
		
		ResultSet rs = null;

		Connection conn = Basedao.getConnection();

		PreparedStatement ps = null;
		
		
		try {
			String sql = "select * from shop_order WHERE ORDER_UID=? and ORDER_TYPE=? order by ORDER_ID  ";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, uid);
			ps.setInt(2, type);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				SHOP_ORDER d = new SHOP_ORDER(
						rs.getInt("ORDER_ID"), 
						rs.getInt("ORDER_PID"), 
						rs.getString("ORDER_PNAME"), 
						rs.getFloat("ORDER_PPR"), 
						rs.getInt("ORDER_PNUM"), 
						rs.getInt("ORDER_PSTK"), 
						rs.getString("ORDER_PFNAME"), 
						rs.getString("ORDER_UID"), 
						rs.getString("ORDER_UADR"), 
						rs.getInt("ORDER_TYPE")
						);
				list.add(d);	
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		return list;
	}

	public static SHOP_ORDER selectByPidUid(int pid, String uid,int type) {
		// TODO Auto-generated method stub
		SHOP_ORDER order = null;
		
		ResultSet rs = null;

		Connection conn = Basedao.getConnection();

		PreparedStatement ps = null;
		
		
		
		try {
			String sql = "select * from shop_order WHERE ORDER_UID=? and ORDER_PID=? and ORDER_TYPE=? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, uid);
			ps.setInt(2, pid);
			ps.setInt(3, type);
			
			
			rs = ps.executeQuery();
			while (rs.next()) {
				order =new SHOP_ORDER(
						rs.getInt("ORDER_ID"), 
						rs.getInt("ORDER_PID"), 
						rs.getString("ORDER_PNAME"), 
						rs.getFloat("ORDER_PPR"), 
						rs.getInt("ORDER_PNUM"), 
						rs.getInt("ORDER_PSTK"), 
						rs.getString("ORDER_PFNAME"), 
						rs.getString("ORDER_UID"), 
						rs.getString("ORDER_UADR"), 
						rs.getInt("ORDER_TYPE"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return order;
	}

	public static int updateByNum(int pid, String uid, int num,int type) {
		// TODO Auto-generated method stub
		
		String sql = "update shop_order set ORDER_PNUM=? where ORDER_UID=? and ORDER_PID=? and ORDER_TYPE=? ";

		Object[] params = {num,uid,pid,type };

		return Basedao.exectuIUD(sql, params);
	}

	public static int del(int oid) {
		// TODO Auto-generated method stub
		
		String sql = "delete from shop_order where ORDER_ID=?  ";

		Object[] params = {oid };

		return Basedao.exectuIUD(sql, params);
	}

	public static int[] totalpage(int count, String keyword) {
		// TODO Auto-generated method stub
		
		
		int arr[] = { 0, 1 };

		Connection conn = Basedao.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String sql = null;
			if (keyword != null) {
				sql = "select count(*) from shop_order where ORDER_PNAME like ?";
				ps = conn.prepareStatement(sql);
				String s = "%" + keyword + "%";
				ps.setString(1, s);

			} else {
				sql = "select count(*) from shop_order";
				ps = conn.prepareStatement(sql);
			}

			rs = ps.executeQuery();

			while (rs.next()) {
				arr[0] = rs.getInt(1);

				if (arr[0] % count == 0) {
					arr[1] = arr[0] / count;
				} else {
					arr[1] = arr[0] / count + 1;
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}

		return arr;
	}

	public static ArrayList<SHOP_ORDER> selectall(int cpage, int count, String keyword) {
		// TODO Auto-generated method stub
		ArrayList<SHOP_ORDER> list = new ArrayList<SHOP_ORDER>();

		ResultSet rs = null;

		Connection conn = Basedao.getConnection();

		PreparedStatement ps = null;

		try {

			String sql;
			if (keyword != null) {
				sql = "select * from shop_order where ORDER_PNAME like ? order by ORDER_UID,ORDER_ID  limit ?, ?";
				ps = conn.prepareStatement(sql);
				String s = "%" + keyword + "%";
				ps.setString(1, s);
				ps.setInt(2, (cpage - 1) * count);
				ps.setInt(3, count);
			} else {
				sql = "select * from shop_order order by ORDER_UID,ORDER_ID  limit ?, ?";
				ps = conn.prepareStatement(sql);

				ps.setInt(1, (cpage - 1) * count);
				ps.setInt(2, count);
			}

			rs = ps.executeQuery();

			while (rs.next()) {
				SHOP_ORDER u = new SHOP_ORDER(
						rs.getInt("ORDER_ID"), 
						rs.getInt("ORDER_PID"), 
						rs.getString("ORDER_PNAME"), 
						rs.getFloat("ORDER_PPR"), 
						rs.getInt("ORDER_PNUM"), 
						rs.getInt("ORDER_PSTK"), 
						rs.getString("ORDER_PFNAME"), 
						rs.getString("ORDER_UID"), 
						rs.getString("ORDER_UADR"), 
						rs.getInt("ORDER_TYPE"));

				list.add(u);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}

		return list;
		
		
	}

	public static SHOP_ORDER selectById(int id) {
		// TODO Auto-generated method stub
		
SHOP_ORDER order = null;
		
		ResultSet rs = null;

		Connection conn = Basedao.getConnection();

		PreparedStatement ps = null;
		
		
		
		try {
			String sql = "select * from shop_order WHERE ORDER_ID=? ";
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			while (rs.next()) {
				order =new SHOP_ORDER(
						rs.getInt("ORDER_ID"), 
						rs.getInt("ORDER_PID"), 
						rs.getString("ORDER_PNAME"), 
						rs.getFloat("ORDER_PPR"), 
						rs.getInt("ORDER_PNUM"), 
						rs.getInt("ORDER_PSTK"), 
						rs.getString("ORDER_PFNAME"), 
						rs.getString("ORDER_UID"), 
						rs.getString("ORDER_UADR"), 
						rs.getInt("ORDER_TYPE"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return order;
		
		
		
		
	}

}
