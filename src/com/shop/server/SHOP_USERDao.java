package com.shop.server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.shop.dao.Basedao;
import com.shop.entity.SHOP_USER;

public class SHOP_USERDao {
	/*
	 * 加入数据库
	 */
	public static int insert(SHOP_USER u) {
		String sql = "insert into shop_user value( ?, ?, ?, ?, DATE_FORMAT(?,'%Y-%m-%d'), ?, ?, ?, ?)";

		Object[] params = { u.getUSER_ID(), u.getUSER_NAME(), u.getUSER_PASSWORD(), u.getUSER_SEX(),
				u.getUSER_BIRTHDAY(), u.getUSER_EMAIL(), u.getUSER_MOBILE(), u.getUSER_ADDRESS(), u.getUSER_STATUS() };

		return Basedao.exectuIUD(sql, params);
	}

	/*
	 * 统计页面和总记录数
	 */
	public static int[] totalpage(int count, String keyword) {
		int arr[] = { 0, 1 };

		Connection conn = Basedao.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String sql = null;
			if (keyword != null) {
				sql = "select count(*) from shop_user where USER_ID like ?";
				ps = conn.prepareStatement(sql);
				String s = "%" + keyword + "%";
				ps.setString(1, s);

			} else {
				sql = "select count(*) from shop_user";
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

	/*
	 * 查询数据库记录
	 */
	public static ArrayList<SHOP_USER> selectall(int cpage, int count, String keyword) {

		ArrayList<SHOP_USER> list = new ArrayList<SHOP_USER>();

		ResultSet rs = null;

		Connection conn = Basedao.getConnection();

		PreparedStatement ps = null;

		try {

			String sql;
			if (keyword != null) {
				sql = "select * from shop_user where USER_ID like ? order by USER_ID  limit ?, ?";
				ps = conn.prepareStatement(sql);
				String s = "%" + keyword + "%";
				ps.setString(1, s);
				ps.setInt(2, (cpage - 1) * count);
				ps.setInt(3, count);
			} else {
				sql = "select * from shop_user order by USER_ID  limit ?, ?";
				ps = conn.prepareStatement(sql);

				ps.setInt(1, (cpage - 1) * count);
				ps.setInt(2, count);
			}

			rs = ps.executeQuery();

			while (rs.next()) {
				SHOP_USER u = new SHOP_USER(rs.getString("USER_ID"), rs.getString("USER_NAME"),
						rs.getString("USER_PASSWORD"), rs.getString("USER_SEX"), rs.getString("USER_BIRTHDAY"),
						rs.getString("USER_EMAIL"), rs.getString("USER_MOBILE"), rs.getString("USER_ADDRESS"),
						rs.getInt("USER_STATUS"));

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

	/*
	 * 按用户ID查询数据库记录
	 */
	public static SHOP_USER selectById(String id) {

		SHOP_USER u = null;

		ResultSet rs = null;

		Connection conn = Basedao.getConnection();

		PreparedStatement ps = null;

		try {

			String sql = null;

			sql = "select * from shop_user where USER_ID = ?";
			ps = conn.prepareStatement(sql);

			ps.setString(1, id);

			rs = ps.executeQuery();

			while (rs.next()) {
				u = new SHOP_USER(rs.getString("USER_ID"), rs.getString("USER_NAME"), rs.getString("USER_PASSWORD"),
						rs.getString("USER_SEX"), rs.getString("USER_BIRTHDAY"), rs.getString("USER_EMAIL"),
						rs.getString("USER_MOBILE"), rs.getString("USER_ADDRESS"), rs.getInt("USER_STATUS"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}

		return u;
	}

	/*
	 * 更新用户信息
	 */
	public static int update(SHOP_USER u) {
		String sql = "update shop_user set USER_NAME=?,USER_PASSWORD=?,USER_SEX=?,USER_BIRTHDAY=DATE_FORMAT(?,'%Y-%m-%d'),USER_EMAIL=?,USER_MOBILE=?,USER_ADDRESS=?,USER_STATUS=? where USER_ID=?";

		// value( ?, ?, ?, ?, DATE_FORMAT(?,'%Y-%m-%d'), ?, ?, ?, ?)

		Object[] params = {

				u.getUSER_NAME(), u.getUSER_PASSWORD(), u.getUSER_SEX(), u.getUSER_BIRTHDAY(), u.getUSER_EMAIL(),
				u.getUSER_MOBILE(), u.getUSER_ADDRESS(), u.getUSER_STATUS(), u.getUSER_ID() };

		return Basedao.exectuIUD(sql, params);
	}

	/*
	 * 删除单个用户信息
	 */
	public static int delete(String id) {
		String sql = "delete from shop_user where USER_ID=? and user_status!=2";

		// value( ?, ?, ?, ?, DATE_FORMAT(?,'%Y-%m-%d'), ?, ?, ?, ?)

		Object[] params = { id };

		return Basedao.exectuIUD(sql, params);
	}

	/*
	 * 按ID查询，注册ID验证唯一
	 */
	public static int selectByName(String name) {
		// TODO Auto-generated method stub
		int count = 0;

		Connection conn = Basedao.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String sql = "select count(*) from shop_user where USER_ID=?";
			ps = conn.prepareStatement(sql);

			ps.setString(1, name);

			rs = ps.executeQuery();

			while (rs.next()) {
				count = rs.getInt(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}

		return count;
	}

	/*
	 * 用户登录验证密码和昵称
	 * 
	 */
	public static int selectByNP(String name, String password) {
		// TODO Auto-generated method stub
		int count = 0;

		Connection conn = Basedao.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String sql = "select count(*) from shop_user where USER_ID=? and USER_PASSWORD=?";
			ps = conn.prepareStatement(sql);

			ps.setString(1, name);
			ps.setString(2, password);

			rs = ps.executeQuery();

			while (rs.next()) {
				count = rs.getInt(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}

		return count;
	}

	public static SHOP_USER selectUser(String name, String password) {
		// TODO Auto-generated method stub
		SHOP_USER u = null;

		ResultSet rs = null;

		Connection conn = Basedao.getConnection();

		PreparedStatement ps = null;

		try {

			String sql = null;

			sql = "select * from shop_user where USER_ID = ? and USER_PASSWORD=?";
			ps = conn.prepareStatement(sql);

			ps.setString(1, name);
			ps.setString(2, password);

			rs = ps.executeQuery();

			while (rs.next()) {
				u = new SHOP_USER(rs.getString("USER_ID"), rs.getString("USER_NAME"), rs.getString("USER_PASSWORD"),
						rs.getString("USER_SEX"), rs.getString("USER_BIRTHDAY"), rs.getString("USER_EMAIL"),
						rs.getString("USER_MOBILE"), rs.getString("USER_ADDRESS"), rs.getInt("USER_STATUS"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}

		return u;
		
	}

}
