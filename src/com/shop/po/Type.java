package com.shop.po;

public class Type {
	private int tid;
	private String tname;
	private String tphoto;
	private String tdesc;
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getTphoto() {
		return tphoto;
	}
	public void setTphoto(String tphoto) {
		this.tphoto = tphoto;
	}
	public String getTdesc() {
		return tdesc;
	}
	public void setTdesc(String tdesc) {
		this.tdesc = tdesc;
	}
	public Type(int tid, String tname, String tphoto, String tdesc) {
		super();
		this.tid = tid;
		this.tname = tname;
		this.tphoto = tphoto;
		this.tdesc = tdesc;
	}
	public Type() {
		super();
	}
	@Override
	public String toString() {
		return "Type [tid=" + tid + ", tname=" + tname + ", tphoto=" + tphoto + ", tdesc=" + tdesc + "]";
	}
	
	
}
