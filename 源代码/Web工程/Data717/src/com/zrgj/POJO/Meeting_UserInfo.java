package com.zrgj.POJO;

public class Meeting_UserInfo {
	private int UI_ID;
	private int MI_ID;
	private int MU_ID;
	public int getUI_ID() {
		return UI_ID;
	}
	public void setUI_ID(int uI_ID) {
		this.UI_ID = uI_ID;
	}
	public int getMI_ID() {
		return MI_ID;
	}
	public void setMI_ID(int mI_ID) {
		this.MI_ID = mI_ID;
	}
	public int getMU_ID() {
		return MU_ID;
	}
	public void setMU_ID(int mU_ID) {
		this.MU_ID = mU_ID;
	}
	@Override
	public String toString() {
		return "Meeting_UserInfo [UI_ID=" + UI_ID + ", MI_ID=" + MI_ID + ", MU_ID=" + MU_ID + "]";
	}
	
}
