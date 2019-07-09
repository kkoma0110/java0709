package com.shop.po;

public class Goods {
		
		private int gid;
		private String gname;
		private String gprice;
		private int quantity;//����
		private String gphoto;
		private String gdesc;
		private int gtype;
		public int getGid() {
			return gid;
		}
		public void setGid(int gid) {
			this.gid = gid;
		}
		public String getGname() {
			return gname;
		}
		public void setGname(String gname) {
			this.gname = gname;
		}
		public String getGprice() {
			return gprice;
		}
		public void setGprice(String gprice) {
			this.gprice = gprice;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public String getGphoto() {
			return gphoto;
		}
		public void setGphoto(String gphoto) {
			this.gphoto = gphoto;
		}
		public String getGdesc() {
			return gdesc;
		}
		public void setGdesc(String gdesc) {
			this.gdesc = gdesc;
		}
		public int getGtype() {
			return gtype;
		}
		public void setGtype(int gtype) {
			this.gtype = gtype;
		}
		public Goods(int gid, String gname, String gprice, int quantity, String gphoto, String gdesc, int gtype) {
			super();
			this.gid = gid;
			this.gname = gname;
			this.gprice = gprice;
			this.quantity = quantity;
			this.gphoto = gphoto;
			this.gdesc = gdesc;
			this.gtype = gtype;
		}
		public Goods() {
			super();
		}
		@Override
		public String toString() {
			return "Goods [gid=" + gid + ", gname=" + gname + ", gprice=" + gprice + ", quantity=" + quantity
					+ ", gphoto=" + gphoto + ", gdesc=" + gdesc + ", gtype=" + gtype + "]";
		}
		
		
}
