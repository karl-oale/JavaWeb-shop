package com.shop.entity;

import java.util.ArrayList;

import com.shop.server.SHOP_CATEDao;

public class SHOP_CATE {
	private int CATE_ID;
	private String CATE_NAME;
	private int CATE_PARENT;
	public SHOP_CATE(int cATE_ID, String cATE_NAME, int cATE_PARENT) {
		super();
		CATE_ID = cATE_ID;
		CATE_NAME = cATE_NAME;
		CATE_PARENT = cATE_PARENT;
	}
	public int getCATE_ID() {
		return CATE_ID;
	}
	public void setCATE_ID(int cATE_ID) {
		CATE_ID = cATE_ID;
	}
	public String getCATE_NAME() {
		return CATE_NAME;
	}
	public void setCATE_NAME(String cATE_NAME) {
		CATE_NAME = cATE_NAME;
	}
	public int getCATE_PARENT() {
		return CATE_PARENT;
	}
	public void setCATE_PARENT(int cATE_PARENT) {
		CATE_PARENT = cATE_PARENT;
	}
	public static ArrayList<SHOP_CATE> selectfcate() {
		// TODO Auto-generated method stub
		ArrayList<SHOP_CATE> catelist = SHOP_CATEDao.selectall(); 
		
		ArrayList<SHOP_CATE> fcatelist = new ArrayList<SHOP_CATE>();
		
		for (SHOP_CATE cate : catelist) {
			if (cate.getCATE_PARENT()==0 && cate.getCATE_ID() !=0) {
				fcatelist.add(cate);
			}
		}
		
		
		return fcatelist;
	}
	public static ArrayList<SHOP_CATE> selectccate() {
		// TODO Auto-generated method stub
ArrayList<SHOP_CATE> catelist = SHOP_CATEDao.selectall(); 
		
		ArrayList<SHOP_CATE> ccatelist = new ArrayList<SHOP_CATE>();
		
		for (SHOP_CATE cate : catelist) {
			if (cate.getCATE_PARENT() != 0) {
				ccatelist.add(cate);
			}
		}
		
		
		return ccatelist;
	}
	
	
	
}
