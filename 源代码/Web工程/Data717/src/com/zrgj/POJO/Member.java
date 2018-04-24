package com.zrgj.POJO;

public class Member {
private String MI_TITLE;
private String MR_ADDRESS;
private String MI_START_TIME;
private String MI_END_TIME;
private String MI_BOOK_TIME;
private String UI_NAME;
public String getMI_NAME() {
	return MI_TITLE;
}
public void setMI_NAME(String mI_NAME) {
	MI_TITLE = mI_NAME;
}
public String getMR_ADDRESS() {
	return MR_ADDRESS;
}
public void setMR_ADDRESS(String mR_ADDRESS) {
	MR_ADDRESS = mR_ADDRESS;
}
public String getMI_START_TIME() {
	return MI_START_TIME;
}
public void setMI_START_TIME(String mI_START_TIME) {
	MI_START_TIME = mI_START_TIME;
}
public String getMI_END_TIME() {
	return MI_END_TIME;
}
public void setMI_END_TIME(String mI_END_TIME) {
	MI_END_TIME = mI_END_TIME;
}
public String getMI_BOOK_TIME() {
	return MI_BOOK_TIME;
}
public void setMI_BOOK_TIME(String mI_AP_TIME) {
	MI_BOOK_TIME = mI_AP_TIME;
}
public String getUI_NAME() {
	return UI_NAME;
}
public void setUI_NAME(String uI_NAME) {
	UI_NAME = uI_NAME;
}
@Override
public String toString() {
	return "Member [MI_NAME=" + MI_TITLE + ", MR_ADDRESS=" + MR_ADDRESS + ", MI_START_TIME=" + MI_START_TIME
			+ ", MI_END_TIME=" + MI_END_TIME + ", MI_AP_TIME=" + MI_BOOK_TIME + ", UI_NAME=" + UI_NAME + "]";
}


}
