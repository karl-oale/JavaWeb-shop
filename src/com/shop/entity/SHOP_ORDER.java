package com.shop.entity;

public class SHOP_ORDER {
	private int ORDER_ID;
	private  int ORDER_PID;
	private  String ORDER_PNAME;
	private  float ORDER_PPR;
	private  int ORDER_PNUM;
	private  int ORDER_PSTK;
	private  String ORDER_PFNAME;
	private  String ORDER_UID;
	private  String ORDER_UADR;
	private  int ORDER_TYPE;
	public SHOP_ORDER(int oRDER_ID, int oRDER_PID, String oRDER_PNAME, float oRDER_PPR, int oRDER_PNUM, int oRDER_PSTK,
			String oRDER_PFNAME, String oRDER_UID, String oRDER_UADR, int oRDER_TYPE) {
		super();
		ORDER_ID = oRDER_ID;
		ORDER_PID = oRDER_PID;
		ORDER_PNAME = oRDER_PNAME;
		ORDER_PPR = oRDER_PPR;
		ORDER_PNUM = oRDER_PNUM;
		ORDER_PSTK = oRDER_PSTK;
		ORDER_PFNAME = oRDER_PFNAME;
		ORDER_UID = oRDER_UID;
		ORDER_UADR = oRDER_UADR;
		ORDER_TYPE = oRDER_TYPE;
	}
	public int getORDER_ID() {
		return ORDER_ID;
	}
	public void setORDER_ID(int oRDER_ID) {
		ORDER_ID = oRDER_ID;
	}
	public int getORDER_PID() {
		return ORDER_PID;
	}
	public void setORDER_PID(int oRDER_PID) {
		ORDER_PID = oRDER_PID;
	}
	public String getORDER_PNAME() {
		return ORDER_PNAME;
	}
	public void setORDER_PNAME(String oRDER_PNAME) {
		ORDER_PNAME = oRDER_PNAME;
	}
	public float getORDER_PPR() {
		return ORDER_PPR;
	}
	public void setORDER_PPR(float oRDER_PPR) {
		ORDER_PPR = oRDER_PPR;
	}
	public int getORDER_PNUM() {
		return ORDER_PNUM;
	}
	public void setORDER_PNUM(int oRDER_PNUM) {
		ORDER_PNUM = oRDER_PNUM;
	}
	public int getORDER_PSTK() {
		return ORDER_PSTK;
	}
	public void setORDER_PSTK(int oRDER_PSTK) {
		ORDER_PSTK = oRDER_PSTK;
	}
	public String getORDER_PFNAME() {
		return ORDER_PFNAME;
	}
	public void setORDER_PFNAME(String oRDER_PFNAME) {
		ORDER_PFNAME = oRDER_PFNAME;
	}
	public String getORDER_UID() {
		return ORDER_UID;
	}
	public void setORDER_UID(String oRDER_UID) {
		ORDER_UID = oRDER_UID;
	}
	public String getORDER_UADR() {
		return ORDER_UADR;
	}
	public void setORDER_UADR(String oRDER_UADR) {
		ORDER_UADR = oRDER_UADR;
	}
	public int getORDER_TYPE() {
		return ORDER_TYPE;
	}
	public void setORDER_TYPE(int oRDER_TYPE) {
		ORDER_TYPE = oRDER_TYPE;
	}
	
	
	
	
}
