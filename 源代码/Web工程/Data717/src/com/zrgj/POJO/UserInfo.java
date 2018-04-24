package com.zrgj.POJO;

public class UserInfo {
private int UI_ID;
private String UI_ACCOUNT;
private String UI_PWD;
private String UI_NAME;
private String UI_DEPARTMENT;
private String UI_ROLES;
private String UI_STATUS;
private String UI_TEL;
private String UI_EMAIL;
public String getUI_TEL() {
	return UI_TEL;
}
public void setUI_TEL(String uI_TEL) {
	UI_TEL = uI_TEL;
}
public String getUI_EMAIL() {
	return UI_EMAIL;
}
public void setUI_EMAIL(String uI_EMAIL) {
	UI_EMAIL = uI_EMAIL;
}
public String getUI_ROLES() {
	return UI_ROLES;
}
public void setUI_ROLES(String uI_ROLES) {
	UI_ROLES = uI_ROLES;
}
public String getUI_STATUS() {
	return UI_STATUS;
}
public void setUI_STATUS(String uI_STATUS) {
	UI_STATUS = uI_STATUS;
}
public int getUI_ID() {
	return UI_ID;
}
public void setUI_ID(int uI_ID) {
	UI_ID = uI_ID;
}
public String getUI_ACCOUNT() {
	return UI_ACCOUNT;
}
public void setUI_ACCOUNT(String uI_ACCOUNT) {
	UI_ACCOUNT = uI_ACCOUNT;
}
public String getUI_PWD() {
	return UI_PWD;
}
public void setUI_PWD(String uI_PWD) {
	UI_PWD = uI_PWD;
}
public String getUI_NAME() {
	return UI_NAME;
}
public void setUI_NAME(String uI_NAME) {
	UI_NAME = uI_NAME;
}
public String getUI_DEPARTMENT() {
	return UI_DEPARTMENT;
}
public void setUI_DEPARTMENT(String uI_DEPARTMENT) {
	UI_DEPARTMENT = uI_DEPARTMENT;
}
@Override
public String toString() {
	return "UserInfo [UI_ID=" + UI_ID + ", UI_ACCOUNT=" + UI_ACCOUNT + ", UI_PWD=" + UI_PWD + ", UI_NAME=" + UI_NAME
			+ ", UI_DEPARTMENT=" + UI_DEPARTMENT + ", UI_ROLES=" + UI_ROLES + ", UI_STATUS=" + UI_STATUS + "]";
}

}
