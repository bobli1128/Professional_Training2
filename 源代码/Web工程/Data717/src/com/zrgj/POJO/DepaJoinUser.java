package com.zrgj.POJO;

public class DepaJoinUser {
	   	private int departmentid;
	   	private String departmentname;
	   	private int UI_ID;
		private String UI_ACCOUNT;
		private String UI_PWD;
		private String UI_NAME;
		private String UI_DEPARTMENT;
		private String UI_STATUS;
		private String UI_ROLES;
		private String UI_TEL;
		private String UI_EMAIL;
		
		
		public String getUI_TEL() {
			return UI_TEL;
		}

		public void setUI_TEL(String uI_TEL) {
			this.UI_TEL = uI_TEL;
		}

		public String getUI_EMAIL() {
			return UI_EMAIL;
		}

		public void setUI_EMAIL(String uI_EMAIL) {
			this.UI_EMAIL = uI_EMAIL;
		}

		public String getUI_STATUS() {
			return UI_STATUS;
		}

		public void setUI_STATUS(String uI_STATUS) {
			this.UI_STATUS = uI_STATUS;
		}

		public String getUI_ROLES() {
			return UI_ROLES;
		}

		public void setUI_ROLES(String uI_ROLES) {
			this.UI_ROLES = uI_ROLES;
		}

		
		public int getUI_ID() {
			return UI_ID;
		}

		public void setUI_ID(int uI_ID) {
			this.UI_ID = uI_ID;
		}

		public String getUI_ACCOUNT() {
			return UI_ACCOUNT;
		}

		public void setUI_ACCOUNT(String uI_ACCOUNT) {
			this.UI_ACCOUNT = uI_ACCOUNT;
		}

		public String getUI_PWD() {
			return UI_PWD;
		}

		public void setUI_PWD(String uI_PWD) {
			this.UI_PWD = uI_PWD;
		}

		public String getUI_NAME() {
			return UI_NAME;
		}

		public void setUI_NAME(String uI_NAME) {
			this.UI_NAME = uI_NAME;
		}

		public String getUI_DEPARTMENT() {
			return UI_DEPARTMENT;
		}

		public void setUI_DEPARTMENT(String uI_DEPARTMENT) {
			this.UI_DEPARTMENT = uI_DEPARTMENT;
		}

	public int getDepartmentid() {
		return departmentid;
	}
	public void setDepartmentid(int departmentid) {
		this.departmentid = departmentid;
	}
	public String getDepartmentname() {
		return departmentname;
	}
	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}

	@Override
	public String toString() {
		return "DepaJoinUser [departmentid=" + departmentid + ", departmentname=" + departmentname + ", UI_ID=" + UI_ID
				+ ", UI_ACCOUNT=" + UI_ACCOUNT + ", UI_PWD=" + UI_PWD + ", UI_NAME=" + UI_NAME + ", UI_DEPARTMENT="
				+ UI_DEPARTMENT + ", UI_STATUS=" + UI_STATUS + ", UI_ROLES=" + UI_ROLES + ", UI_TEL=" + UI_TEL
				+ ", UI_EMAIL=" + UI_EMAIL + "]";
	}
	
}
