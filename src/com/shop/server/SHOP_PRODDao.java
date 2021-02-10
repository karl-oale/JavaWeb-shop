package com.shop.server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.shop.dao.Basedao;
import com.shop.entity.SHOP_PROD;

public class SHOP_PRODDao {

	public static int add(SHOP_PROD prod) {
		// TODO Auto-generated method stub
		String sql = "insert into shop_prod value( null, ?, ?, ?, ?, ?, ?, ?)";

		Object[] params = { 
				prod.getPROD_NAME(), 
				prod.getPROD_PR(), 
				prod.getPROD_DESC(), 
				prod.getPROD_STK(),
				prod.getPROD_FID(), 
				prod.getPROD_CID(), 
				prod.getPROD_FNAME() 
		};

		return Basedao.exectuIUD(sql, params);

	}

	public static ArrayList<SHOP_PROD> select(int cpage, int count, String keyword) {
		// TODO Auto-generated method stub
		ArrayList<SHOP_PROD> list = new ArrayList<SHOP_PROD>();
		
		ResultSet rs = null;

		Connection conn = Basedao.getConnection();

		PreparedStatement ps = null;
		
		try {
			String sql= null;
			
			if (keyword != null) {
				sql = "select * from shop_prod where PROD_NAME like ? order by PROD_FID,PROD_CID  limit ?, ?";
				ps = conn.prepareStatement(sql);
				String s = "%" + keyword + "%";
				ps.setString(1, s);
				ps.setInt(2, (cpage - 1) * count);
				ps.setInt(3, count);
				
			}else {
				sql = "select * from shop_prod order by PROD_FID,PROD_CID  limit ?, ?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, (cpage - 1) * count); 
				ps.setInt(2, count);
			}
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				SHOP_PROD p = new SHOP_PROD(
						rs.getInt("PROD_ID"), 
						rs.getString("PROD_NAME"),
						rs.getFloat("PROD_PR"),
						rs.getString("PROD_DESC"),
						rs.getInt("PROD_STK"),
						rs.getInt("PROD_FID"),
						rs.getInt("PROD_CID"),
						rs.getString("PROD_FNAME")
						);
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		return list;
		
		
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
				sql = "select count(*) from shop_prod where PROD_NAME like ?";
				ps = conn.prepareStatement(sql);
				String s = "%" + keyword + "%";
				ps.setString(1, s);

			} else {
				sql = "select count(*) from shop_prod";
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

	public static int del(int id) {
		// TODO Auto-generated method stub
		String sql = "delete from shop_prod where PROD_ID=? ";
		Object[] params = { id };

		return Basedao.exectuIUD(sql, params);
		
	}

	public static ArrayList<SHOP_PROD> selectall() {
		// TODO Auto-generated method stub
		ArrayList<SHOP_PROD> list = new ArrayList<SHOP_PROD>();
		
		ResultSet rs = null;

		Connection conn = Basedao.getConnection();

		PreparedStatement ps = null;
		
		String sql = "select * from shop_prod order by PROD_FID,PROD_CID";
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				SHOP_PROD p = new SHOP_PROD(
						rs.getInt("PROD_ID"), 
						rs.getString("PROD_NAME"),
						rs.getFloat("PROD_PR"),
						rs.getString("PROD_DESC"),
						rs.getInt("PROD_STK"),
						rs.getInt("PROD_FID"),
						rs.getInt("PROD_CID"),
						rs.getString("PROD_FNAME")
						);
				list.add(p);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}

	public static ArrayList<SHOP_PROD> selectByFidCid(int fid, int cid) {
		// TODO Auto-generated method stub
		
		ArrayList<SHOP_PROD> list = new ArrayList<SHOP_PROD>();
		
		ResultSet rs = null;

		Connection conn = Basedao.getConnection();

		PreparedStatement ps = null;
		
		String sql = null;
		try {
			
			
			sql = "select * from shop_prod where PROD_FID=? and PROD_CID=?";
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, fid);
			ps.setInt(2, cid);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				SHOP_PROD p = new SHOP_PROD(
						rs.getInt("PROD_ID"), 
						rs.getString("PROD_NAME"),
						rs.getFloat("PROD_PR"),
						rs.getString("PROD_DESC"),
						rs.getInt("PROD_STK"),
						rs.getInt("PROD_FID"),
						rs.getInt("PROD_CID"),
						rs.getString("PROD_FNAME")
						);
				list.add(p);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	public static ArrayList<SHOP_PROD> selectByFid(int fid) {
		// TODO Auto-generated method stub
		ArrayList<SHOP_PROD> list = new ArrayList<SHOP_PROD>();
		
		ResultSet rs = null;

		Connection conn = Basedao.getConnection();

		PreparedStatement ps = null;
		
		String sql = null;
		try {
			
			
			sql = "select * from shop_prod where PROD_FID=? order by PROD_CID";
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, fid);
			
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				SHOP_PROD p = new SHOP_PROD(
						rs.getInt("PROD_ID"), 
						rs.getString("PROD_NAME"),
						rs.getFloat("PROD_PR"),
						rs.getString("PROD_DESC"),
						rs.getInt("PROD_STK"),
						rs.getInt("PROD_FID"),
						rs.getInt("PROD_CID"),
						rs.getString("PROD_FNAME")
						);
				list.add(p);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	public static SHOP_PROD selectById(int pid) {
		// TODO Auto-generated method stub
		
		
		SHOP_PROD prod = null;
		
		ResultSet rs = null;

		Connection conn = Basedao.getConnection();

		PreparedStatement ps = null;
		
		String sql = null;
		try {
			
			
			sql = "select * from shop_prod where PROD_ID=? ";
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, pid);
			
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				prod = new SHOP_PROD(
						rs.getInt("PROD_ID"), 
						rs.getString("PROD_NAME"),
						rs.getFloat("PROD_PR"),
						rs.getString("PROD_DESC"),
						rs.getInt("PROD_STK"),
						rs.getInt("PROD_FID"),
						rs.getInt("PROD_CID"),
						rs.getString("PROD_FNAME")
						);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prod;
		
		
		
		
	}

	public static int update(SHOP_PROD prod) {
		// TODO Auto-generated method stub
		String sql = "update shop_prod set PROD_NAME=?,PROD_PR=?,PROD_DESC=?,PROD_STK=?,PROD_FID=?,PROD_CID=? where PROD_ID=?";

		// value( ?, ?, ?, ?, DATE_FORMAT(?,'%Y-%m-%d'), ?, ?, ?, ?)

		Object[] params = {
				prod.getPROD_NAME(),
				prod.getPROD_PR(),
				prod.getPROD_DESC(),
				prod.getPROD_STK(),
				prod.getPROD_FID(),
				prod.getPROD_CID(),
				prod.getPROD_ID()
		};

		return Basedao.exectuIUD(sql, params);
		
	}

}
