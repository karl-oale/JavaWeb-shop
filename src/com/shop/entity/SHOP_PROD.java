package com.shop.entity;

public class SHOP_PROD {
	private int PROD_ID;
	private String PROD_NAME ;
	private float PROD_PR;
	private String PROD_DESC;
	private int PROD_STK;
	private int PROD_FID;
	private int PROD_CID;
	private String PROD_FNAME;
	
	public SHOP_PROD(int pROD_ID, String pROD_NAME, float pROD_PR, String pROD_DESC, int pROD_STK, int pROD_FID,
			int pROD_CID, String pROD_FNAME) {
		super();
		PROD_ID = pROD_ID;
		PROD_NAME = pROD_NAME;
		PROD_PR = pROD_PR;
		PROD_DESC = pROD_DESC;
		PROD_STK = pROD_STK;
		PROD_FID = pROD_FID;
		PROD_CID = pROD_CID;
		PROD_FNAME = pROD_FNAME;
	}

	public int getPROD_ID() {
		return PROD_ID;
	}

	public void setPROD_ID(int pROD_ID) {
		PROD_ID = pROD_ID;
	}

	public String getPROD_NAME() {
		return PROD_NAME;
	}

	public void setPROD_NAME(String pROD_NAME) {
		PROD_NAME = pROD_NAME;
	}

	public float getPROD_PR() {
		return PROD_PR;
	}

	public void setPROD_PR(float pROD_PR) {
		PROD_PR = pROD_PR;
	}

	public String getPROD_DESC() {
		return PROD_DESC;
	}

	public void setPROD_DESC(String pROD_DESC) {
		PROD_DESC = pROD_DESC;
	}

	public int getPROD_STK() {
		return PROD_STK;
	}

	public void setPROD_STK(int pROD_STK) {
		PROD_STK = pROD_STK;
	}

	public int getPROD_FID() {
		return PROD_FID;
	}

	public void setPROD_FID(int pROD_FID) {
		PROD_FID = pROD_FID;
	}

	public int getPROD_CID() {
		return PROD_CID;
	}

	public void setPROD_CID(int pROD_CID) {
		PROD_CID = pROD_CID;
	}

	public String getPROD_FNAME() {
		return PROD_FNAME;
	}

	public void setPROD_FNAME(String pROD_FNAME) {
		PROD_FNAME = pROD_FNAME;
	}

	
	
	
	
}
